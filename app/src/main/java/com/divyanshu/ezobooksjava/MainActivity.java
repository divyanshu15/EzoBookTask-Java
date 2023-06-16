package com.divyanshu.ezobooksjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.divyanshu.ezobooksjava.Api.RetrofitInstance;
import com.divyanshu.ezobooksjava.databinding.ActivityMainBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnShowAuthor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getData();
                binding.authorNameHeading.setVisibility(View.VISIBLE);
            }
        });
    }

    private void getData() {
        RetrofitInstance.getApiInterface().getData().enqueue(new Callback<ResponseDataClass>() {
            @Override
            public void onResponse(Call<ResponseDataClass> call, Response<ResponseDataClass> response) {
                if (response.isSuccessful()) {
                    ResponseDataClass responseData = response.body();
                    if (responseData != null && !responseData.isEmpty()) {
                        String authorName = responseData.get(0).getAuthor();
                        binding.authorName.setText(authorName);
                        Glide.with(MainActivity.this)
                                .load(responseData.get(0).getDownloadUrl())
                                .into(binding.authorimg);
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Unable to get response from server", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseDataClass> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Unable to get response from server", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
