package com.example.loveexam;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;

public class MainActivity extends Activity implements OnClickListener {

	ListView lv;
	ArrayList<Person> list = new ArrayList<Person>();
	MyAdapter adapter;
	EditText txtName,txtnumber;
	AlertDialog dialog;

	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.lv=(ListView) this.findViewById(R.id.listView1);
        adapter = new MyAdapter(this,list);
        this.lv.setAdapter(adapter);
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        //getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		

	
		
		
		txtName= new EditText(this);
		txtName.setPadding(10, 10, 10, 10);
		txtName.setHint("Enter Name");
	//	txtName.setInputType(InputType.);
		
		txtnumber = new EditText(this);
		txtnumber.setPadding(10, 10, 10, 10);
		txtnumber.setHint("Enter Number");
		txtnumber.setInputType(InputType.TYPE_CLASS_NUMBER);
	
		LinearLayout layout = new LinearLayout(this);
		layout.setOrientation(LinearLayout.VERTICAL);
		layout.addView(txtName);
		layout.addView(txtnumber);
		
		
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle("Add Person");
		builder.setView(layout);

		
		builder.setPositiveButton("Save", this);
		builder.setNegativeButton("Cancel", this);
		
		 dialog = builder.create();
		dialog.show();
		
		return super.onOptionsItemSelected(item);
	}


	@Override
	public void onClick(DialogInterface arg0, int arg1) {
		// TODO Auto-generated method stub
		switch(arg1){
		case DialogInterface.BUTTON_POSITIVE:
			String s = this.txtName.getText().toString();
			String p = this.txtnumber.getText().toString();
			
			list.add(new Person(R.drawable.img1, s, p));
			adapter.notifyDataSetChanged();
			
			break;
		
		case DialogInterface.BUTTON_NEGATIVE:
			dialog.dismiss();
			break;
		}
		
	}
    
	
	
    
}
