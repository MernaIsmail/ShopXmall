package com.example.merna.shopxmall;

import android.Manifest;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.merna.shopxmall.Model.Shop;
import com.example.merna.shopxmall.mPicasso.PicassoClient;
import com.example.merna.shopxmall.utils.Constants;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.Query;
import com.firebase.ui.FirebaseListAdapter;

/**
 * Created by Merna on 5/1/2016.
 */

public class shopAdapter extends FirebaseListAdapter<Shop> {
    Activity activity;

    public shopAdapter(FragmentActivity activity, Class<Shop> modelClass, int modelLayout, Query ref) {
        super(activity, modelClass, modelLayout, ref);
        this.activity = activity;
    }

    @Override
    protected void populateView(View v, final Shop model, final int position) {
        super.populateView(v, model);

        TextView name = (TextView) v.findViewById(R.id.ShopName);
        TextView category = (TextView) v.findViewById(R.id.ShopCategory);
        ImageView reportIcon = (ImageView) v.findViewById(R.id.reportIcon);
        ImageView offerIcon = (ImageView) v.findViewById(R.id.offerIcon);
        ImageView detailIcon = (ImageView) v.findViewById(R.id.detailsIcon);
        ImageView logo = (ImageView) v.findViewById(R.id.ShopLogo);


        name.setText(model.getShopName());
        category.setText(model.getCategory());

        String img = model.getLogo();

        if (model.getLogo() != null) {
            PicassoClient.downloadImg(activity, img, logo);
        }

    }
}
