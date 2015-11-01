package com.shevchenkodev.doctorcat.adapter;

import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.shevchenkodev.doctorcat.R;
import com.shevchenkodev.doctorcat.fragment.PetFragment;
import com.shevchenkodev.doctorcat.model.ModelPet;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Администратор on 31.10.2015.
 */
public class PetAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<ModelPet> pets = new ArrayList<>();

    PetFragment petFragment;


    public ModelPet getPet(int position) {
        return pets.get(position);
    }

    public void addPet(ModelPet pet) {
        pets.add(pet);
        notifyItemInserted(getItemCount() - 1);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {


        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.model_task, viewGroup, false);
        TextView title = (TextView) v.findViewById(R.id.tvTaskTitle);
        TextView date = (TextView) v.findViewById(R.id.tvTaskDate);
        //   CircleImageView priority = (CircleImageView) v.findViewById(R.id.cvTaskPriority);

        return new TaskViewHolder(v, title, date);


        //  return new PetAdapter.TaskViewHolder(v, title, date);
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        holder.itemView.setEnabled(true);
        //     final ModelPet pet = (ModelPet)  ;
        ModelPet pet = new ModelPet();
        final TaskViewHolder taskViewHolder = (TaskViewHolder) holder;

        final View itemView = taskViewHolder.itemView;
        final Resources resources = itemView.getResources();

        taskViewHolder.name.setText(pet.getPetName());
        taskViewHolder.date.setText(null);
    }

    @Override
    public int getItemCount() {
        return pets.size();
    }

    protected class TaskViewHolder extends RecyclerView.ViewHolder {
        protected TextView name;
        protected TextView date;


        public TaskViewHolder(View itemView, TextView name, TextView date) {
            super(itemView);
            this.name = name;
            this.date = date;

        }
    }


    public void onPetAdded(ModelPet newPet) {
        petFragment.addPet(newPet);

    }
}
