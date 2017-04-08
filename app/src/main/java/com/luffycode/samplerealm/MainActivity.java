package com.luffycode.samplerealm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.luffycode.samplerealm.dao.Cart;
import com.luffycode.samplerealm.dao.CartDAO;
import com.luffycode.samplerealm.dao.Category;
import com.luffycode.samplerealm.dao.CategoryDAO;
import com.luffycode.samplerealm.dao.Meal;
import com.luffycode.samplerealm.dao.MealDAO;
import com.luffycode.samplerealm.dao.User;
import com.luffycode.samplerealm.dao.UserDAO;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Button btnSaveUser;
    private Button btnShowUser;
    private Button btnSaveCategory;
    private Button btnShowCategory;
    private Button btnSaveMeal;
    private Button btnShowMeal;
    private Button btnSaveCart;
    private Button btnShowCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSaveUser = (Button) findViewById(R.id.btnSaveUser);
        btnShowUser = (Button) findViewById(R.id.btnShowUser);
        btnSaveCategory = (Button) findViewById(R.id.btnSaveCategory);
        btnShowCategory = (Button) findViewById(R.id.btnShowCategory);
        btnSaveMeal = (Button) findViewById(R.id.btnSaveMeal);
        btnShowMeal = (Button) findViewById(R.id.btnShowMeal);
        btnSaveCart = (Button) findViewById(R.id.btnSaveCart);
        btnShowCart = (Button) findViewById(R.id.btnShowCart);

        btnSaveUser.setOnClickListener(listener);
        btnShowUser.setOnClickListener(listener);
        btnSaveCategory.setOnClickListener(listener);
        btnShowCategory.setOnClickListener(listener);
        btnSaveMeal.setOnClickListener(listener);
        btnShowMeal.setOnClickListener(listener);
        btnSaveCart.setOnClickListener(listener);
        btnShowCart.setOnClickListener(listener);
    }

    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btnSaveUser:
                    user(true);
                    break;
                case R.id.btnShowUser:
                    user(false);
                    break;
                case R.id.btnSaveCategory:
                    category(true);
                    break;
                case R.id.btnShowCategory:
                    category(false);
                    break;
                case R.id.btnSaveMeal:
                    meal(true);
                    break;
                case R.id.btnShowMeal:
                    meal(false);
                    break;
                case R.id.btnSaveCart:
                    cart(true);
                    break;
                case R.id.btnShowCart:
                    cart(false);
                    break;
            }
        }
    };

    private void user(boolean save){
        UserDAO userDAO = new UserDAO();
        if (save){
            userDAO.insert("Badrus", "mail@mail.com", "08567236377", "Jln Kertajaya", "qwerty");
        }else{
            for (int i = 0; i < userDAO.getUsers().size(); i++) {
                User user = userDAO.getUsers().get(i);
                Log.d("name", user.getName());
                Log.d("address", user.getAddress());
                Log.d("phone", user.getPhone());
                Log.d("email", user.getEmail());
                Log.d("password", user.getPassword());
            }
        }
    }

    private void category(boolean save){
        CategoryDAO categoryDAO = new CategoryDAO();
        if (save){
            List<String> categories = new ArrayList<>();
            categories.add("Food & Snack");
            categories.add("Beverages");
            categories.add("Additional");
            categoryDAO.insert(categories);
        }else{
            for (int i = 0; i < categoryDAO.getCategories().size(); i++) {
                Category user = categoryDAO.getCategories().get(i);
                Log.d("name", user.getName());
                Log.d("id", String.valueOf(user.getId()));
            }
        }
    }

    private void meal(boolean save){
        MealDAO mealDAO = new MealDAO();
        if (save){
            String note = "Dimasak dengan bumbu pilihan dan ditangani oleh chef yang berpengalaman";
            String noteBeverages = "Minuman dengan bumbu rempah pilihan";

            int category0 = 1;
            int category1 = 2;
            int category2 = 3;

            List<Meal> meals = new ArrayList<>();
            meals.add(new Meal("Ayam Besek", 75000, "ayam_besek_juanda", note, category0));
            meals.add(new Meal("Chicken Rice Box", 25000, "chicken_rice_box", note, category0));
            meals.add(new Meal("Chicken Wing Blackpepper Sauce", 75000, "chicken_wing_sc_blackpapper", note, category0));
            meals.add(new Meal("Chicken Wing Egg Salted", 30000, "chicken_wing_salted_egg_sauce", note, category0));
            meals.add(new Meal("Thaiwan Chicken Street", 20000, "thaiwan_chicken_street", note, category0));

            meals.add(new Meal("Es Dawet", 10000, "es_dawet", noteBeverages, category1));
            meals.add(new Meal("Sereh Pandan", 15000, "sereh_pandan", noteBeverages, category1));
            meals.add(new Meal("Ic Chocolate", 7000, "ice_chocolate", noteBeverages, category1));
            meals.add(new Meal("Coca Cola", 10000, "coca_cola", noteBeverages, category1));
            meals.add(new Meal("Fanta", 10000, "fanta", noteBeverages, category1));
            meals.add(new Meal("Sprite", 10000, "sprite", noteBeverages, category1));

            meals.add(new Meal("French Fries", 10000, "french_friespng", note, category2));
            meals.add(new Meal("Mash Potatoes", 15000, "mash_photatoes", note, category2));
            meals.add(new Meal("Nasi Putih", 7000, "nasi_putih", note, category2));
            mealDAO.insert(meals);
        }else{
            for (int i = 0; i < mealDAO.getMeal(0).size(); i++) {
                Meal user = mealDAO.getMeal(0).get(i);
                Log.d("id", String.valueOf(user.getId()));
                Log.d("name", user.getName());
                Log.d("price", String.valueOf(user.getPrice()));
                Log.d("image", String.valueOf(user.getImage()));
                Log.d("note", user.getNote());
            }
        }
    }

    private void cart(boolean save){
        CartDAO cartDAO = new CartDAO();
        if (save){
            int qty = 1;
            int queryMeal = 1;
            Meal meal = new MealDAO().getSingleMeal(queryMeal);
            Log.d("meal", meal.getName());
            cartDAO.insert(qty, meal);
        }else{
            for (int i = 0; i < cartDAO.getCarts().size(); i++) {
                Cart user = cartDAO.getCarts().get(i);
                Log.d("id", String.valueOf(user.getQty()));
                Log.d("name", user.getUser().getName());
                Log.d("name", user.getMeals().getName());
                /*for (int j = 0; j < user.getMeals().size(); j++) {
                    Meal meal = user.getMeals().get(j);
                    Log.d("name", meal.getName());
                    Log.d("name", String.valueOf(meal.getPrice()));
                }*/
            }
        }
    }
}
