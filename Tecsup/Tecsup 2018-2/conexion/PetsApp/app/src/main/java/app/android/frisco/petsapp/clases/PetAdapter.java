package app.android.frisco.petsapp.clases;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import app.android.frisco.petsapp.R;
import app.android.frisco.petsapp.interfaces.ApiService;

public class PetAdapter extends RecyclerView.Adapter<PetAdapter.ViewHolder>  {

    private List<Pet> pets;

    public PetAdapter(List<Pet> pets){
        this.pets = pets;
    }

    public void setPets(List<Pet> pets){
        this.pets = pets;
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView nombre;
        public TextView raza;
        public TextView edad;
        public ImageView picture;


        public ViewHolder(View itemView) {
            super(itemView);
            picture = (ImageView) itemView.findViewById(R.id.picture_image_pet);
            nombre = (TextView) itemView.findViewById(R.id.fullname_pet);
            raza = (TextView) itemView.findViewById(R.id.raza_pet);
            edad = (TextView) itemView.findViewById(R.id.edad_pet);
        }
    }

    @Override
    public PetAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pet, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(PetAdapter.ViewHolder viewHolder, final int position) {
        final Pet pets = this.pets.get(position);
        final Context context = viewHolder.itemView.getContext();
        viewHolder.nombre.setText(pets.getNombre());
        viewHolder.raza.setText(pets.getRaza());
        viewHolder.edad.setText(pets.getEdad());

        //String url = ApiService.API_BASE_URL + "/productos/images/" + pets.getImagen();
        //Picasso.with(context).load(url).into(viewHolder.picture);

    }

    @Override
    public int getItemCount() {
        return this.pets.size();
    }

}
