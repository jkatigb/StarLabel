package com.studio.ocarina.starlabel.StarWarsApplication.mvp.view;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.jakewharton.rxbinding2.view.RxView;
import com.studio.ocarina.starlabel.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observable;


@SuppressLint("ViewConstructor")
public class StarWarsActivityView extends FrameLayout {

    @BindView(R.id.searchEditText)
    EditText searchBar;

    @BindView(R.id.searchButton)
    Button searchButton;

    private final ProgressDialog progressDialog = new ProgressDialog(getContext());
    public StarWarsActivityView(Activity activity) {
        super(activity);
        inflate(getContext(), R.layout.search_view, this);
        progressDialog.setMessage("Searching....");
        ButterKnife.bind(this);
    }

    public void showToast(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_LONG).show();
    }

    public Observable<Object> observeButton() {
        return RxView.clicks(searchButton);
    }

    public void showDialog(boolean isLoading){
        if (isLoading) {
            progressDialog.show();
        } else {
            progressDialog.dismiss();
        }
    }

    public String getSearchBarText() {
        return searchBar.getText().toString();
    }
}
