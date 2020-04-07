package com.example.tourist;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.SearchView;
import android.widget.Toast;
import com.example.tourist.Model.Tourist;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;

public class Dashboard extends AppCompatActivity {

    DatabaseReference ref; // Create database reference object
    ArrayList<Tourist> list; // Create a array list to store firebase data
    RecyclerView recyclerView; // create object for the Recycler View
    SearchView searchView; // create the object for the SearchView
    private StorageReference mStorageRef; //Create the database reference object
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        ref= FirebaseDatabase.getInstance().getReference().child("Country"); // Refer to the country node in firebase database
        mStorageRef = FirebaseStorage.getInstance().getReference(); //  Refer to the Firebase data storage
        recyclerView = findViewById(R.id.rv);
        searchView = findViewById(R.id.searchView); // Assign the recycler view and search view to the objects
    }
    // set the Listener to the RecyclerView
    AdapterClass.RecyclerViewClickListener listener = new AdapterClass.RecyclerViewClickListener() {
        @Override
        public void onClick(View view, int position) {
            Intent intent = new Intent(Dashboard.this, Country.class);
            intent.putExtra("CountryName", list.get(position).getCountryName());
            startActivity(intent);
        }
    };
    @Override
    protected void onStart() {
        super.onStart();
        if(ref!=null){
            ref.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    if(dataSnapshot.exists())
                    {   list= new ArrayList<>();
                        for(DataSnapshot ds : dataSnapshot.getChildren())
                        {
                            list.add(ds.getValue(Tourist.class)); // store firebase data to a list using tourist class
                        }
                        //Pass the Image with getApplicationContext,List and Listener to the recyclerview adapter
                        AdapterClass adapterClass = new AdapterClass(getApplicationContext(),list,listener);
                        recyclerView.setAdapter(adapterClass);
                    }
                }
                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                    Toast.makeText(Dashboard.this,databaseError.getMessage(),Toast.LENGTH_SHORT).show();

                }
            });
        }

        //Code for the Search function
        if(searchView != null)
        {
            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String query) {return false;}

                @Override
                public boolean onQueryTextChange(String newText) {
                    search(newText);
                    return true;
                }
            });
        }
    }
    private void search(String str){
        ArrayList<Tourist> myList = new ArrayList<>();
        for(Tourist object : list)
        {
            if(object.getCountryName().toLowerCase().contains(str.toLowerCase()))
            {myList.add(object);}
        }
        AdapterClass adapterClass = new AdapterClass(getApplicationContext(),myList,listener);
        recyclerView.setAdapter(adapterClass);
    }
}
