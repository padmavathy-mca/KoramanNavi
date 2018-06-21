package com.example.yuzzle.koramannavi;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class RestaurantImagesFragment extends Fragment {

    private String selectedRestaurantName;
    private RestaurantImagesAdapter imagesAdapter;
    private RecyclerView rv2;
    private RecyclerView.LayoutManager layoutManager;
    private List<RestaurantImagesItems> restaurantImagesItems;
    private String[] restaurantNames = {"The Himalayan Korean Restaurant", "Thalassery Restaurant", "North Indian and Bengali Mess", "Tella Tales", "Tandoori Hut", "Chinita", "Chung Wah Restaurant",
            "Cafe Medley", "Truffles", "Bistro OUI", "Soup'ermanz Kitchen", "Shree Thali", "Hotel Tibet", "Gudguda Prime Cafe", "7 Plates"};
    private Integer theHimalayanKoreanRestaurant[] = {R.drawable.the_himalayan_korean_restaurant_1,R.drawable.the_himalayan_korean_restaurant_2,R.drawable.the_himalayan_korean_restaurant_3,R.drawable.the_himalayan_korean_restaurant_4,R.drawable.the_himalayan_korean_restaurant_5,R.drawable.the_himalayan_korean_restaurant_6,R.drawable.the_himalayan_korean_restaurant_7};
    private Integer thalasseryRestaurant[] = {R.drawable.thalassery_restaurant_1,R.drawable.thalassery_restaurant_2,R.drawable.thalassery_restaurant_3,R.drawable.thalassery_restaurant_4,R.drawable.thalassery_restaurant_5,R.drawable.thalassery_restaurant_6,R.drawable.thalassery_restaurant_7};
    private Integer northIndianandBengaliMess[] = {R.drawable.north_indian_and_bangali_mess,R.drawable.north_indian_and_bangali_mess_2,R.drawable.north_indian_and_bangali_mess_3,R.drawable.north_indian_and_bangali_mess_4};
    private Integer tellaTales[] = {R.drawable.tella_tales_1,R.drawable.tella_tales_2,R.drawable.tella_tales_3,R.drawable.tella_tales_4};
    private Integer tandooriHut[] = {R.drawable.tandoori_hut_1,R.drawable.tandoori_hut_2,R.drawable.tandoori_hut_3,R.drawable.tandoori_hut_4,R.drawable.tandoori_hut_5,R.drawable.tandoori_hut_6,R.drawable.tandoori_hut_7};
    private Integer chinita[] = {R.drawable.chinita_1,R.drawable.chinita_2,R.drawable.chinita_3,R.drawable.chinita_4,R.drawable.chinita_5};
    private Integer chungWahRestaurant[] = {R.drawable.chung_wah_restaurant_1,R.drawable.chung_wah_restaurant_2,R.drawable.chung_wah_restaurant_3,R.drawable.chung_wah_restaurant_4};
    private Integer cafeMedley[] = {R.drawable.cafe_medley_1,R.drawable.cafe_medley_2,R.drawable.cafe_medley_3};
    private Integer truffles[] = {R.drawable.truffles_1,R.drawable.truffles_2,R.drawable.truffles_3,R.drawable.truffles_4,R.drawable.truffles_5,R.drawable.truffles_6,R.drawable.truffles_7,R.drawable.truffles_8};
    private Integer bistroOUI[] = {R.drawable.bistro_oui_1,R.drawable.bistro_oui_2,R.drawable.bistro_oui_3,R.drawable.bistro_oui_4,R.drawable.bistro_oui_5};
    private Integer soupermanzKitchen[] = {R.drawable.soupermanz_kitchen_1,R.drawable.soupermanz_kitchen_2,R.drawable.soupermanz_kitchen_3,R.drawable.soupermanz_kitchen_4,R.drawable.soupermanz_kitchen_5};
    private Integer shreeThali[] = {R.drawable.shree_thali_1,R.drawable.shree_thali_2};
    private Integer hotelTibet[] = {R.drawable.hotel_tibet_1,R.drawable.hotel_tibet_2,R.drawable.hotel_tibet_3};
    private Integer gudgudaPrimeCafe[] = {R.drawable.gudguda_prime_cafe_1,R.drawable.gudguda_prime_cafe_2,R.drawable.gudguda_prime_cafe_3,R.drawable.gudguda_prime_cafe_4,R.drawable.gudguda_prime_cafe_5,R.drawable.gudguda_prime_cafe_6};
    private Integer echoes[] = {R.drawable.echoes_1,R.drawable.echoes_2,R.drawable.echoes_3,R.drawable.echoes_4,R.drawable.echoes_5,R.drawable.echoes_6,R.drawable.echoes_7,R.drawable.echoes_8,R.drawable.echoes_9,R.drawable.echoes_10};
    private Integer sevenPlates[] = {R.drawable.seven_plates_1,R.drawable.seven_plates_2,R.drawable.seven_plates_3,R.drawable.seven_plates_4,R.drawable.seven_plates_5,R.drawable.seven_plates_6,R.drawable.seven_plates_7};

    public RestaurantImagesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_restaurant_images, container, false);
        //a = getActivity().getIntent().getExtras().getString("restaurant","nothing sent");
        //        a = intent.getStringExtra("restaurant");
        selectedRestaurantName = getArguments().getString("restaurant");

        rv2 = view.findViewById(R.id.recyclerview2);

        restaurantImagesItems = new ArrayList<>();

        switch (selectedRestaurantName) {
            case "The Himalayan Korean Restaurant":
                for (int i=0 ; i<theHimalayanKoreanRestaurant.length ; i++) {
                    restaurantImagesItems.add(new RestaurantImagesItems(theHimalayanKoreanRestaurant[i], "image" + (i + 1)));
                }
                break;
            case "Thalassery Restaurant":
                for (int i=0 ; i<thalasseryRestaurant.length ; i++) {
                    restaurantImagesItems.add(new RestaurantImagesItems(thalasseryRestaurant[i], "image" + (i+1)));
                }
                break;
            case "North Indian and Bengali Mess":
                for (int i=0 ; i<northIndianandBengaliMess.length ; i++) {
                    restaurantImagesItems.add(new RestaurantImagesItems(northIndianandBengaliMess[i], "image" + (i+1)));
                }
                break;
            case "Tella Tales":
                for (int i=0 ; i<tellaTales.length ; i++) {
                    restaurantImagesItems.add(new RestaurantImagesItems(tellaTales[i], "a"));
                }
                break;
            case "Tandoori Hut":
                for (int i=0 ; i<tandooriHut.length ; i++){
                    restaurantImagesItems.add(new RestaurantImagesItems(tandooriHut[i],"image"+(i+1)));
                }
                break;
            case "Chinita":
                for (int i=0 ; i<chinita.length ; i++){
                restaurantImagesItems.add(new RestaurantImagesItems(chinita[i],"image"+(i+1)));
                }
                break;
            case "Chung Wah Restaurant":
                for (int i=0 ; i<chungWahRestaurant.length ; i++){
                    restaurantImagesItems.add(new RestaurantImagesItems(chungWahRestaurant[i],"image"+(i+1)));
                }
                break;
            case "Cafe Medley":
                for (int i=0 ; i<cafeMedley.length ; i++){
                    restaurantImagesItems.add(new RestaurantImagesItems(cafeMedley[i],"image"+(i+1)));
                }
                break;
            case "Truffles":
                for (int i=0 ; i<truffles.length ; i++){
                    restaurantImagesItems.add(new RestaurantImagesItems(truffles[i],"image"+(i+1)));
                }
                break;
            case "Bistro OUI":
                for (int i=0 ; i<bistroOUI.length ; i++){
                    restaurantImagesItems.add(new RestaurantImagesItems(bistroOUI[i],"image"+(i+1)));
                }
                break;
            case "Soup'ermanz Kitchen":
                for (int i=0 ; i<soupermanzKitchen.length ; i++){
                    restaurantImagesItems.add(new RestaurantImagesItems(soupermanzKitchen[i],"image"+(i+1)));
                }
                break;
            case "Shree Thali":
                for (int i=0 ; i<shreeThali.length ; i++){
                    restaurantImagesItems.add(new RestaurantImagesItems(shreeThali[i],"image"+(i+1)));
                }
                break;
            case "Hotel Tibet":
                for (int i=0 ; i<hotelTibet.length ; i++){
                    restaurantImagesItems.add(new RestaurantImagesItems(hotelTibet[i],"image"+(i+1)));
                }
                break;
            case "Gudguda Prime Cafe":
                for (int i=0 ; i<gudgudaPrimeCafe.length ; i++){
                    restaurantImagesItems.add(new RestaurantImagesItems(gudgudaPrimeCafe[i],"image"+(i+1)));
                }
                break;
            case "7 Plates":
                for (int i=0 ; i<sevenPlates.length ; i++) {
                    restaurantImagesItems.add(new RestaurantImagesItems(sevenPlates[i], "image" + (i+1)));
                }
                break;
            case "Echoes":
                for (int i=0 ; i<echoes.length ; i++) {
                    restaurantImagesItems.add(new RestaurantImagesItems(echoes[i], "image" +(i+1)));
                }
                break;
        }


//        for (int i=0 ; i<restaurantNames.length ; i++) {
//            if (a.equals(restaurantNames[i])) {
//                //add images of the specific restaurant to the lists below
//                for(int j=0 ; j<theHimalayanKoreanRestaurant.length ; j++){
//                    restaurantImagesItems.add(new RestaurantImagesItems(theHimalayanKoreanRestaurant[j],"a"));
//                }
//            }
//        }

        imagesAdapter = new RestaurantImagesAdapter(getContext(),restaurantImagesItems);
        layoutManager = new GridLayoutManager(getContext(),2);
        rv2.setLayoutManager(layoutManager);
        rv2.setAdapter(imagesAdapter);
        return view;
    }

}
