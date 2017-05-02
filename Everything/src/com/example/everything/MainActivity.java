package com.example.everything;

import java.util.ArrayList;



import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity implements OnItemClickListener {

	GridView gv;
	ArrayList<Person> list = new ArrayList<Person>();
	GridAdapter adapter;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        this.gv=(GridView) this.findViewById(R.id.gridView1);
        adapter= new GridAdapter(this,list);
        this.gv.setAdapter(adapter);
        
        list.add(new Person (R.drawable.img1,"Slark","BSIT"));
        list.add(new Person (R.drawable.img2,"Crystal Maiden","BEED"));
        list.add(new Person (R.drawable.img3,"Drow Ranger","BSPE"));
        list.add(new Person (R.drawable.img4,"Earth Shaker","BSCE"));
        list.add(new Person (R.drawable.img5,"Death Prophet","BSCRIM"));
        list.add(new Person (R.drawable.img6,"Ogre Magi","BSHRM"));
        list.add(new Person (R.drawable.img7,"Lina","BSIT"));
        list.add(new Person (R.drawable.img8,"Anti Mage","BSP"));
        list.add(new Person (R.drawable.img9,"Wind Ranger","BPO"));
        list.add(new Person (R.drawable.img10,"Underlord","BDO"));
        list.add(new Person (R.drawable.img11,"Invoker","BPI"));
        list.add(new Person (R.drawable.img12,"Spectre","BSEE"));
        
      
        
     
        this.gv.setOnItemClickListener(this);
        
    }
    	


    
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }





	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		// TODO Auto-generated method stub
		ImageView iv = new ImageView(this);
		iv.setImageResource(list.get(arg2).getImage());
		TextView tv = new TextView(this);
		tv.setText(list.get(arg2).getCourse());
		
		LinearLayout layout = new LinearLayout(this);
		layout.setOrientation(LinearLayout.HORIZONTAL);
		layout.addView(iv);
		layout.addView(tv);
		
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle(list.get(arg2).getName());
		builder.setView(layout);
		builder.setNeutralButton("Okay", null);
		AlertDialog dialog = builder.create();
		dialog.show();
	}
    
}
