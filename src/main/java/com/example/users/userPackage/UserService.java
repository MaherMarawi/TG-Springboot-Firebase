package com.example.users.userPackage;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
public class UserService {


    private static final Firestore dbFirestore = FirestoreClient.getFirestore();


    public List getUsers() throws InterruptedException, ExecutionException {

        List<User> response = new ArrayList<>();
        User user;
        CollectionReference documentReference = dbFirestore.collection("users");
        for (DocumentSnapshot doc : documentReference.get().get()) {
            user = doc.toObject(User.class);
            user.setId(doc.getId());
            response.add(user);
        }
        return response;
    }

    public User getUser(String ID) throws InterruptedException, ExecutionException {

        DocumentReference documentReference = dbFirestore.collection("users").document(ID);
        ApiFuture<DocumentSnapshot> future = documentReference.get();
        DocumentSnapshot document = future.get();
        User user = null;
        if(document.exists()) {
            user = document.toObject(User.class);
            user.setId(document.getId());
            return user;
        }else {
            return null;
        }
    }

    public void addUser(User user) throws InterruptedException, ExecutionException {

        ApiFuture<com.google.cloud.firestore.WriteResult> collectionsApiFuture = dbFirestore
                .collection("users").document().set(user);
    }

    public void deleteUser(String id) {

        DocumentReference documentReference = dbFirestore.collection("users").document(id);
        ApiFuture<WriteResult> future = documentReference.delete();
    }

    public void updateUser(String id, User user) {

        DocumentReference documentReference = dbFirestore.collection("users").document(id);
        ApiFuture<WriteResult> writeResultApiFuture = documentReference.set(user);
    }
}
