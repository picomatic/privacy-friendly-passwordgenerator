package org.secuso.privacyfriendlypasswordgenerator.helpers;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.secuso.privacyfriendlypasswordgenerator.R;
import org.secuso.privacyfriendlypasswordgenerator.database.MetaData;

import java.util.List;

/**
 * Code according to the tutorial from https://code.tutsplus.com/tutorials/getting-started-with-recyclerview-and-cardview-on-android--cms-23465
 * accessed 17th June 2016
 */


public class MetaDataAdapter extends RecyclerView.Adapter<MetaDataAdapter.MetaDataViewHolder> {

    private List<MetaData> metaDataList;

    public MetaDataAdapter(List<MetaData> metaData) {

        this.metaDataList = metaData;
    }


    @Override
    public MetaDataViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_metadata, parent, false);

        return new MetaDataViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MetaDataViewHolder holder, int position) {
        holder.domain.setText(metaDataList.get(position).getDOMAIN());
        holder.length.setText(Integer.toString(metaDataList.get(position).getLENGTH()));
        holder.iteration.setText(Integer.toString(metaDataList.get(position).getITERATION()));

        //TODO make dynamic Text
        if (metaDataList.get(position).getHAS_LETTERS_LOW() == 1) {
            holder.hasLettersLow.setText("Lowercase");
        }

        if (metaDataList.get(position).getHAS_LETTERS_UP() == 1) {
            holder.hasLettersUp.setText("Uppercase");
        }

        if (metaDataList.get(position).getHAS_SYMBOLS() == 1) {
            holder.hasSymbols.setText("Special Characters");
        }

        if (metaDataList.get(position).getHAS_NUMBERS() == 1) {
            holder.hasNumbers.setText("Numbers");
        }
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public int getItemCount() {
        return metaDataList.size();
    }

    public class MetaDataViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        TextView domain;
        TextView length;
        TextView iteration;
        TextView hasNumbers;
        TextView hasSymbols;
        TextView hasLettersLow;
        TextView hasLettersUp;

        public MetaDataViewHolder(View itemView) {
            super(itemView);
            cardView = (CardView) itemView.findViewById(R.id.card_view);
            domain = (TextView) itemView.findViewById(R.id.domainTextView);
            length = (TextView) itemView.findViewById(R.id.length);
            iteration = (TextView) itemView.findViewById(R.id.iteration);
            hasLettersLow = (TextView) itemView.findViewById(R.id.hasLettersLowTextView);
            hasLettersUp = (TextView) itemView.findViewById(R.id.hasLettersUpTextView);
            hasNumbers = (TextView) itemView.findViewById(R.id.hasNumbersTextView);
            hasSymbols = (TextView) itemView.findViewById(R.id.hasSymbolsTextView);
        }
    }

}
