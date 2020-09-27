package com.esq.e_grocery.utils;

import com.esq.e_grocery.domain.model.PopularMenuItem;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class FireBaseUtil {
    public static FirebaseDatabase sFirebaseDatabase;
    public static DatabaseReference sDatabaseReference;

    private static FireBaseUtil sfireBaseUtil;
    public static ArrayList<PopularMenuItem> sPopularMenuItems;

    private FireBaseUtil(){}

    public static void openReference(String ref) {
        if (sfireBaseUtil == null) {
            sfireBaseUtil = new FireBaseUtil();
            sFirebaseDatabase = FirebaseDatabase.getInstance();
            sPopularMenuItems = new ArrayList<PopularMenuItem>();
        }
        sDatabaseReference = sFirebaseDatabase.getReference().child(ref);
    }


}
