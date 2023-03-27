package com.example.firebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void insertData(View view) {
        Map<String, Object> user = new HashMap<>();
        user.put("first", "Benjamin");
        user.put("last", "Hughes");
        user.put("born", 1987);


        User benjamin = new User("maheen", 25);
        /*
        List<User> users = new ArrayList<>();
        users.add(benjamin);
        Classroom itaClass = new Classroom(users);

         */



        // Add a new document with a generated ID
        db.collection("users")
                .add(benjamin)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        System.out.println("added");
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        System.out.println("error");
                        System.out.println(e);
                    }
                });
    }


    public void setData(View view) {
        Map<String, Object> user = new HashMap<>();
        user.put("first", "set");
        user.put("last", "set");
        user.put("born", 1815);
        user.put("listExample", 23);

        User benjamin = new User("asd", 7);

        // Add a new document with a generated ID
        db.collection("users")
                .document("ada")
                .set(user)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        //Log.d(TAG, "DocumentSnapshot successfully written!");
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        //Log.w(TAG, "Error writing document", e);
                    }
                });
    }

    public void getData(View view) {
        db.collection("users")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                System.out.println(document.getData());
                            }
                        } else {
                            System.out.println(task.getException());
                        }
                    }
                });
    }


    public void createNewUser(View view) {
        EditText firstnameView = findViewById(R.id.firstname);
        String firstname = firstnameView.getText().toString();

        Map<String, Object> user = new HashMap<>();
        user.put("first", firstname);
        user.put("last", firstname);
        user.put("born", firstname);

        // Add a new document with a generated ID
        db.collection("users")
                .add(user)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        System.out.println("added");
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        System.out.println("error");
                        System.out.println(e);
                    }
                });
    }
}