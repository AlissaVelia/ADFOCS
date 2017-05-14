package id.sch.smktelkom_mlg.privateassignment.xirpl403.adfocs;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import id.sch.smktelkom_mlg.privateassignment.xirpl403.adfocs.adapter.SoonAdapter;
import id.sch.smktelkom_mlg.privateassignment.xirpl403.adfocs.model.Result;
import id.sch.smktelkom_mlg.privateassignment.xirpl403.adfocs.model.SourcesResponse;
import id.sch.smktelkom_mlg.privateassignment.xirpl403.adfocs.service.GsonGetRequest;
import id.sch.smktelkom_mlg.privateassignment.xirpl403.adfocs.service.VolleySingleton;




public class RecomenFragment extends Fragment {

    ArrayList<Result> mList = new ArrayList<>();
    SoonAdapter mAdapter;


    public RecomenFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_recomen, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        RecyclerView recyclerView = (RecyclerView) getView().findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        mAdapter = new SoonAdapter(this.getActivity(), mList);
        recyclerView.setAdapter(mAdapter);

        downloadDataSources();
    }


    private void downloadDataSources()
    {
        String url = "https://api.themoviedb.org/3/movie/now_playing?api_key=b56dd418a138d8facd6d2da920f65200&language=en-US&page=1";

        GsonGetRequest<SourcesResponse> myRequest = new GsonGetRequest<SourcesResponse>
                (url, SourcesResponse.class, null, new Response.Listener<SourcesResponse>()
                {

                    @Override
                    public void onResponse(SourcesResponse response)
                    {
                        Log.d("FLOW", "onResponse: " + (new Gson().toJson(response)));

                        mList.addAll(response.results);
                        mAdapter.notifyDataSetChanged();

                    }

                }, new Response.ErrorListener()
                {

                    @Override
                    public void onErrorResponse(VolleyError error)
                    {
                        Log.e("FLOW", "onErrorResponse: ", error);
                    }
                });
        VolleySingleton.getInstance(this.getActivity()).addToRequestQueue(myRequest);
    }
}