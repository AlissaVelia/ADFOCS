package id.sch.smktelkom_mlg.privateassignment.xirpl403.adfocs.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import id.sch.smktelkom_mlg.privateassignment.xirpl403.adfocs.R;
import id.sch.smktelkom_mlg.privateassignment.xirpl403.adfocs.model.Result;
import id.sch.smktelkom_mlg.privateassignment.xirpl403.adfocs.model.SourcesResponse;

/**
 * Created by hyuam on 12/10/2016.
 */

public class RecomenAdapter extends RecyclerView.Adapter<RecomenAdapter.ViewHolder>
{
    Context context;
    ArrayList<Result> list;
    ISourceAdapter mISourceAdapter;

    public RecomenAdapter(Context context, ArrayList<Result> list)
    {   this.context = context;
        this.list = list;
        mISourceAdapter = (ISourceAdapter) context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.reco_list, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position)
    {
        Result result = list.get(position);
        holder.tvName.setText(result.title);
        holder.tvDesc.setText(result.overview);
        Glide.with(context)
                .load("http://image.tmdb.org/t/p/w500"+result.poster_path)
                .into(holder.ivPoster);
    }

    @Override
    public int getItemCount()
    {
        if (list != null)
            return list.size();
        return 0;
    }

    public interface ISourceAdapter
    {
        void showArticles(String id, String name, String sortBy);
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView tvName;
        TextView tvDesc;
        ImageView ivPoster;

        public ViewHolder(View itemView)
        {
            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.textViewName);
            tvDesc = (TextView) itemView.findViewById(R.id.textViewDesc);
            ivPoster = (ImageView) itemView.findViewById(R.id.imageViewPoster);
        }
    }
}
