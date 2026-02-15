package com.example.tp2.ui;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.android.volley.Request;
import com.android.volley.toolbox.StringRequest;
import com.example.tp2.R;
import com.example.tp2.adapters.ArticleAdapter;
import com.example.tp2.Helpers.GsonHelper;
import com.example.tp2.Helpers.VolleyHelper;
import com.example.tp2.models.Article;

import java.util.List;

public class HomeActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArticleAdapter adapter;
    private SwipeRefreshLayout swipeRefresh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        recyclerView = findViewById(R.id.recyclerView);
        swipeRefresh = findViewById(R.id.swipeRefresh);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        loadData();

        swipeRefresh.setOnRefreshListener(this::loadData);
    }

    private void loadData() {

        String url = "https://jsonplaceholder.typicode.com/posts";

        StringRequest request = new StringRequest(Request.Method.GET, url,
                response -> {
                    List<Article> articles = GsonHelper.parseJson(response);
                    adapter = new ArticleAdapter(articles);
                    recyclerView.setAdapter(adapter);
                    swipeRefresh.setRefreshing(false);
                },
                error -> {
                    Toast.makeText(this, "Erreur réseau", Toast.LENGTH_SHORT).show();
                    swipeRefresh.setRefreshing(false);
                });

        VolleyHelper.getInstance(this).addToRequestQueue(request);
    }
}
