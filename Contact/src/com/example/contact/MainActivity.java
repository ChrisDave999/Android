package com.example.contact;

import java.util.ArrayList;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Intent;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity {

	ListView lv;
	ArrayList<Contact> list = new ArrayList<Contact>();
	ItemAdapter adapter;
	AdapterView.AdapterContextMenuInfo info;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.lv = (ListView) this.findViewById(R.id.listView1);
        list.add(new Contact(R.drawable.img1,"Alpha","5556","5556"));
        list.add(new Contact(R.drawable.img2,"Bravo","5554","5554"));
        list.add(new Contact(R.drawable.img3,"Charlie","5556","5556"));
        list.add(new Contact(R.drawable.img4,"Delta","5556","5556"));
        list.add(new Contact(R.drawable.img5,"Echo","5556","5556"));
        list.add(new Contact(R.drawable.img6,"Foxtrot","5556","5556"));
        list.add(new Contact(R.drawable.img7,"Geronimo","5556","5556"));
        
        this.adapter=new ItemAdapter(this,list);
        this.lv.setAdapter(adapter);
        this.registerForContextMenu(lv);
    }
    
    


    @Override
	public boolean onContextItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
    	int id = item.getItemId();
    	switch(id)
    	{
    	case R.id.view: //view contact details
    		
    		LinearLayout layout = new LinearLayout(this);
    		ImageView iv = new ImageView(this);
    		TextView lblName= new TextView(this);
    		TextView lblTel = new TextView(this);
    		
    		iv.setImageResource(list.get(info.position).getImage());
    		lblName.setText(list.get(info.position).getName());
    		lblTel.setText(list.get(info.position).getTel());
    		
    		layout.setOrientation(LinearLayout.VERTICAL);
    		layout.addView(iv);
    		layout.addView(lblName);
    		layout.addView(lblTel);
    		
    		AlertDialog.Builder builder = new AlertDialog.Builder(this);
    		builder.setTitle("Selected Contact");
    		builder.setView(layout);
    		builder.setNeutralButton("Okay", null);
    		
    		AlertDialog dialog = builder.create();
    		dialog.show();
    		
    		break;
    	case R.id.call: //call
    		
    		String telephone = list.get(info.position).getTel();
    		Uri uri = Uri.parse("tel: " + telephone);
    		Intent intent = new Intent(Intent.ACTION_CALL,uri);
    		this.startActivity(intent);
    		
    		break;
    	case R.id.sendsms: //send sms
    		Intent in = new Intent(Intent.ACTION_VIEW);
    		in.putExtra("address", list.get(info.position).getTel());
    		in.putExtra("sms_body", "");
    		in.setType("vnd.android-dir/mms-sms");
    		this.startActivity(in);
    		
    		break;
    	}
    	
		return super.onContextItemSelected(item);
	}




	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		// TODO Auto-generated method stub
		super.onCreateContextMenu(menu, v, menuInfo);
		this.getMenuInflater().inflate(R.menu.contextmenu, menu);
		info = (AdapterContextMenuInfo) menuInfo;
		menu.setHeaderTitle(list.get(info.position).getName());
	}




	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
