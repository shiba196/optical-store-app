package com.example.optical_store.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.optical_store.R;
import com.example.optical_store.adapters.ShowAllAdapter;
import com.example.optical_store.models.ShowAllModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ShowAllActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ShowAllAdapter showAllAdapter;
    List<ShowAllModel> showAllModelList;

    FirebaseFirestore firestore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_all);

        String type = getIntent().getStringExtra("type");

        firestore = FirebaseFirestore.getInstance();
        recyclerView = findViewById(R.id.show_all_rec);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        showAllModelList = new ArrayList<>();
        showAllAdapter = new ShowAllAdapter(this,showAllModelList);
        recyclerView.setAdapter(showAllAdapter);

        firestore.collection("Show All").
                get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {

                        if (task.isSuccessful()){
                            for (DocumentSnapshot doc : task.getResult().getDocuments()){

                                ShowAllModel showAllModel = doc.toObject(ShowAllModel.class);
                                showAllModelList.add(showAllModel);
                                showAllAdapter.notifyDataSetChanged();
                            }
                        }
                    }
                });

        if (type == null && type.isEmpty()){

            firestore.collection("Show All").
                    get()
                    .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<QuerySnapshot> task) {

                            if (task.isSuccessful()){
                                for (DocumentSnapshot doc : task.getResult().getDocuments()){

                                    ShowAllModel showAllModel = doc.toObject(ShowAllModel.class);
                                    showAllModelList.add(showAllModel);
                                    showAllAdapter.notifyDataSetChanged();
                                }
                            }
                        }
                    });

            if (type != null && type.equalsIgnoreCase("Framed glass")){
                firestore.collection("Show All").whereEqualTo("name","Framed glass")
                        .get()
                        .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                            @Override
                            public void onComplete(@NonNull Task<QuerySnapshot> task) {

                                if (task.isSuccessful()){
                                    for (DocumentSnapshot doc : task.getResult().getDocuments()){

                                        ShowAllModel showAllModel = doc.toObject(ShowAllModel.class);
                                        showAllModelList.add(showAllModel);
                                        showAllAdapter.notifyDataSetChanged();
                                    }
                                }
                            }
                        });

            }

            if (type != null && type.equalsIgnoreCase("kids glass")){
                firestore.collection("Show All").whereEqualTo("name","kids glass")
                        .get()
                        .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                            @Override
                            public void onComplete(@NonNull Task<QuerySnapshot> task) {

                                if (task.isSuccessful()){
                                    for (DocumentSnapshot doc : task.getResult().getDocuments()){

                                        ShowAllModel showAllModel = doc.toObject(ShowAllModel.class);
                                        showAllModelList.add(showAllModel);
                                        showAllAdapter.notifyDataSetChanged();
                                    }
                                }
                            }
                        });

            }
        }

    }
}