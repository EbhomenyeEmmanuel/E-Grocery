package com.esq.e_grocery.utils;

import com.esq.e_grocery.domain.model.PopularProducts;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class FireBaseUtil {
    public static FirebaseDatabase sFirebaseDatabase;
    public static DatabaseReference sDatabaseReference;

    private static FireBaseUtil sfireBaseUtil;
    public static ArrayList<PopularProducts> sPopularProducts;

    private FireBaseUtil(){}

    public static void openReference(String ref) {
        if (sfireBaseUtil == null) {
            sfireBaseUtil = new FireBaseUtil();
            sFirebaseDatabase = FirebaseDatabase.getInstance();
            sPopularProducts = new ArrayList<PopularProducts>();
        }
        sDatabaseReference = sFirebaseDatabase.getReference().child(ref);
    }


}
