package com.example.myapplication;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;



import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        Log.d(TAG, "MainActivity: onCreate called");
//        Toast.makeText(this, "MainActivity: onCreate called", Toast.LENGTH_SHORT).show();
//        EdgeToEdge.enable(this);
//        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });
//        TextView welcomeMessage=findViewById(R.id.welcome);
//        Intent intent=getIntent();
//        String message=intent.getStringExtra("message");
//        welcomeMessage.setText(message);
//
//        Button sendReplyButton=findViewById(R.id.ReplyButton);
//        sendReplyButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String reply = "Reply Here...";
//                Intent resultIntent = new Intent();
//                resultIntent.putExtra("reply", reply);
//                setResult(MainActivity.RESULT_OK,resultIntent);
//                finish();
//            }
//        });
        Button showFragment1Button = findViewById(R.id.showFragment1Button);
        Button showFragment2Button = findViewById(R.id.showFragment2Button);

        showFragment1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(new FirstFragment());
            }
        });

        showFragment2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(new SecondFragment());
            }
        });
   }
    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fragment_container, fragment);
        transaction.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.option_menu,menu);
        return true;

    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.action_profile) {
            Toast.makeText(this, "Profile selected", Toast.LENGTH_SHORT).show();
            return true;
        } else if (itemId == R.id.action_settings) {
            Toast.makeText(this, "Settings selected", Toast.LENGTH_SHORT).show();
            return true;
        } else if (itemId == R.id.action_help) {
            Toast.makeText(this, "Help selected", Toast.LENGTH_SHORT).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void showSimpleDialog(){
        new AlertDialog.Builder(this)
                .setTitle("Exit Option Selected")
                .setMessage("You selected Exit. Continue?")
                .setPositiveButton("Yes",(DialogInterface dialog,int which)-> {
                    finishAffinity();
                })
                .setPositiveButton("Yes",(DialogInterface dialog,int which)->
                        Toast.makeText(this, "Confirmed", Toast.LENGTH_SHORT).show())
                .setNegativeButton("No",(DialogInterface dialog,int which)->dialog.dismiss())
                .create()
                .show();
    }
}