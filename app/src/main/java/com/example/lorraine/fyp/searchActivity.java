
package com.example.lorraine.fyp;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class searchActivity extends AppCompatActivity
{
    Button click;
   public static TextView data;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);}}

        /*

        click = (Button) findViewById(R.id.qButton);
        data = (TextView)findViewById(R.id.fetchData);

        click.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                fetchData process = new fetchData();
                process.execute();
            }
        });
    }
}
*/
