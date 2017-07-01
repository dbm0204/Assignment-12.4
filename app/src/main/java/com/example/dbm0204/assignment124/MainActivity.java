package com.example.dbm0204.assignment124;
import android.app.Dialog;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Person> personList;
    //Creating an object of Context
    final Context context=this;

    Button saveBtn,cancelBtn;
    EditText nameET,phoneET,dobET;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar();
        listView=(ListView) findViewById(R.id.list);
        personList = new ArrayList<Person>();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.option_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        Toast.makeText(getApplicationContext(),item.getTitle()+" is clicked", Toast.LENGTH_SHORT).show();

        //Creating dialog and setting its content Values
        final Dialog dialog = new Dialog(context);
        dialog.setContentView(R.layout.custom_dialog);

        //Setting EditTexts and Buttons with their IDs.
        nameET=(EditText)dialog.findViewById(R.id.name_et);
        phoneET=(EditText)dialog.findViewById(R.id.phone_et);
        dobET=(EditText)dialog.findViewById(R.id.dob_et);
        saveBtn=(Button)dialog.findViewById(R.id.save_btn);
        cancelBtn=(Button)dialog.findViewById(R.id.cancel_btn);
        //if SAVE is clicked.
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Toast.makeText(getApplicationContext(),"Save is clicked",Toast.LENGTH_SHORT).show();

                //Checking all details are filled.
                if(!nameET.getText().toString().isEmpty() &&
                        !phoneET.getText().toString().isEmpty() &&
                        !dobET.getText().toString().isEmpty())
                {

                    //creating object of Person and filling information of EditTexts into its fields.
                    Person person=new Person();
                    person.name=nameET.getText().toString();
                    person.phoneNumber=phoneET.getText().toString();
                    person.dateBirth=dobET.getText().toString();

                    //Add object into ArrayList.
                    personList.add(person);

                    //Creating Custom Adapter.
                    CustomAdapter adapter=new CustomAdapter(personList,MainActivity.this);

                    //Setting adapter to listView.
                    listView.setAdapter(adapter);

                    //Setting item Click Listener to listView.
                    listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
                    {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id)
                        {
                            //Showing Toast.
                            Toast.makeText(getApplicationContext(),personList.get(position).name+" is Clicked.",Toast.LENGTH_SHORT).show();
                        }
                    });

                    dialog.dismiss();   //Dismiss dialog
                }
                else
                {
                    //Display toast.
                    Toast.makeText(getApplicationContext(),"Please, Fill All Detaiils",Toast.LENGTH_SHORT).show();
                }
            }
        });

        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                //Display toast.
                Toast.makeText(getApplicationContext(),"Cancel is clicked",Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });

        dialog.show();    //Showing dialog.
        return true;   //returning true.
    }

}
