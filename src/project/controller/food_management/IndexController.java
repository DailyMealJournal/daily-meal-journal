package project.controller.food_management;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import project.dto.FoodDto;
import project.service.ProjectService;

public class IndexController extends Controller {

    private ProjectService service = new ProjectService();
    
    String[] categories = {"Poultry","Meat","Seafood","Fruits & Vegetables","Dairy","Dessert","Beverage","Snacks"};
    String[] foods = {"Chicken","Duck","Beef","Pork","Fish","Crab","Apples","Mangoes","Carrots","Potatoes","Milk","Yogurt","Cheese","Chocolate","Ice Cream","Beer","Fruit Shake","Wine","Soda","Coffee","Chips","French Fries"};
    String[] units = {"100 grams","1 drumstick","100 grams","1 whole","100 grams","1 steak","100 grams","100 grams","1 fillet","100 grams","1 cup","100 grams","1 medium","100 grams","1 whole","100 grams","1 large","100 grams","1 medium","1 cup","1 fl. oz","100 grams","1 container","100 grams","1 slice","1 small","1 bar","100 grams","1 cup","1 can","1 cup","100ml","100 grams","5 fl. oz","1 can","1 cup","30 grams","1 medium","1 large"};
    int[] calories = {239, 211, 337, 583, 332, 847, 157, 129, 112, 83, 98, 52, 95, 60, 201, 41, 30, 77, 163, 148, 18, 59, 100, 371, 104, 38, 235, 216, 286, 145, 130, 55, 83, 123, 144, 2, 150, 312, 480};
    int[] perFood = {2,2,2,1,2,2,2,2,2,2,2,2,2,2,2,1,2,2,1,1,1,2};
    int[] perCat = {2,2,2,4,3,2,5,2};
    
    @Override
    protected Navigation run() throws Exception {
        // TODO Auto-generated method stub
        
        System.out.println(foods.length);
        System.out.println(calories.length);
        System.out.println(units.length);
    
        FoodDto foodDto = new FoodDto();
        int i = 0;
        int j = 0;
        int jTemp;
        int k = 0;
        int kTemp;
        
        /*for(; i < categories.length; i++){ //for each category
            foodDto.setCategory(categories[i]);
            jTemp = 0;
            
            for(; jTemp < perCat[i]; j++, jTemp++){ // for each food in category
                foodDto.setName(foods[j]);
                foodDto.setDescription("");
                foodDto.setPicture("");
                
                service.food(foodDto, "create_food");
                
                kTemp = 0;
                for(; kTemp < perFood[j]; k++, kTemp++){ // for each data in food
                    foodDto.setCalorie(calories[k]);
                    foodDto.setUnit(units[k]);
                    
                    service.food(foodDto, "create_info");
                }
            }
        }*/
        
        /*foodDto.setName("Chicken");
        foodDto.setCategory("Poultry");
        foodDto.setDescription("");
        foodDto.setPicture("");
        service.food(foodDto, "create_food");
        
        foodDto.setCalorie(239);
        foodDto.setUnit("100 grams");
        service.food(foodDto, "create_info");
        
        foodDto.setCalorie(211);
        foodDto.setUnit("1 drumstick");
        service.food(foodDto, "create_info");
        
        foodDto.setName("Duck");
        foodDto.setCategory("Poultry");
        foodDto.setDescription("");
        foodDto.setPicture("");
        service.food(foodDto, "create_food");
        
        foodDto.setCalorie(337);
        foodDto.setUnit("100 grams");
        service.food(foodDto, "create_info");
        
        foodDto.setCalorie(583);
        foodDto.setUnit("1 whole");
        service.food(foodDto, "create_info");
        
        foodDto.setName("Beef");
        foodDto.setCategory("Meat");
        foodDto.setDescription("");
        foodDto.setPicture("");
        service.food(foodDto, "create_food");
        
        foodDto.setCalorie(332);
        foodDto.setUnit("100 grams");
        service.food(foodDto, "create_info");
        
        foodDto.setCalorie(847);
        foodDto.setUnit("1 steak");
        service.food(foodDto, "create_info");
        
        foodDto.setName("Pork");
        foodDto.setCategory("Meat");
        foodDto.setDescription("");
        foodDto.setPicture("");
        service.food(foodDto, "create_food");
        
        foodDto.setCalorie(157);
        foodDto.setUnit("100 grams");
        service.food(foodDto, "create_info");
        
        foodDto.setName("Fish");
        foodDto.setCategory("Seafood");
        foodDto.setDescription("");
        foodDto.setPicture("");
        service.food(foodDto, "create_food");
        
        foodDto.setCalorie(129);
        foodDto.setUnit("100 grams");
        service.food(foodDto, "create_info");
        
        foodDto.setCalorie(112);
        foodDto.setUnit("1 fillet");
        service.food(foodDto, "create_info");
        
        foodDto.setName("Crab");
        foodDto.setCategory("Seafood");
        foodDto.setDescription("");
        foodDto.setPicture("");
        service.food(foodDto, "create_food");
        
        foodDto.setCalorie(83);
        foodDto.setUnit("100 grams");
        service.food(foodDto, "create_info");
        
        foodDto.setCalorie(98);
        foodDto.setUnit("1 cup");
        service.food(foodDto, "create_info");
        
        foodDto.setName("Apples");
        foodDto.setCategory("Fruits & Vegetables");
        foodDto.setDescription("");
        foodDto.setPicture("");
        service.food(foodDto, "create_food");
        
        foodDto.setCalorie(52);
        foodDto.setUnit("100 grams");
        service.food(foodDto, "create_info");
        
        foodDto.setCalorie(95);
        foodDto.setUnit("1 medium");
        service.food(foodDto, "create_info");
        
        foodDto.setName("Mangoes");
        foodDto.setCategory("Fruits & Vegetables");
        foodDto.setDescription("");
        foodDto.setPicture("");
        service.food(foodDto, "create_food");
        
        foodDto.setCalorie(60);
        foodDto.setUnit("100 grams");
        service.food(foodDto, "create_info");
        
        foodDto.setCalorie(201);
        foodDto.setUnit("1 whole");
        service.food(foodDto, "create_info");
        
        foodDto.setName("Carrots");
        foodDto.setCategory("Fruits & Vegetables");
        foodDto.setDescription("");
        foodDto.setPicture("");
        service.food(foodDto, "create_food");
        
        foodDto.setCalorie(41);
        foodDto.setUnit("100 grams");
        service.food(foodDto, "create_info");
        
        foodDto.setCalorie(30);
        foodDto.setUnit("1 large");
        service.food(foodDto, "create_info");
        
        foodDto.setName("Potatoes");
        foodDto.setCategory("Fruits & Vegetables");
        foodDto.setDescription("");
        foodDto.setPicture("");
        service.food(foodDto, "create_food");
        
        foodDto.setCalorie(77);
        foodDto.setUnit("100 grams");
        service.food(foodDto, "create_info");
        
        foodDto.setCalorie(163);
        foodDto.setUnit("1 medium");
        service.food(foodDto, "create_info");
        
        foodDto.setName("Milk");
        foodDto.setCategory("Dairy");
        foodDto.setDescription("");
        foodDto.setPicture("");
        service.food(foodDto, "create_food");
        
        foodDto.setCalorie(148);
        foodDto.setUnit("1 cup");
        service.food(foodDto, "create_info");
        
        foodDto.setCalorie(18);
        foodDto.setUnit("1 fl. oz");
        service.food(foodDto, "create_info");
        
        foodDto.setName("Yogurt");
        foodDto.setCategory("Dairy");
        foodDto.setDescription("");
        foodDto.setPicture("");
        service.food(foodDto, "create_food");
        
        foodDto.setCalorie(59);
        foodDto.setUnit("100 grams");
        service.food(foodDto, "create_info");
        
        foodDto.setCalorie(100);
        foodDto.setUnit("1 container");
        service.food(foodDto, "create_info");
        
        foodDto.setName("Cheese");
        foodDto.setCategory("Dairy");
        foodDto.setDescription("");
        foodDto.setPicture("");
        service.food(foodDto, "create_food");
        
        foodDto.setCalorie(371);
        foodDto.setUnit("100 grams");
        service.food(foodDto, "create_info");
        
        foodDto.setCalorie(104);
        foodDto.setUnit("1 slice");
        service.food(foodDto, "create_info");
        
        foodDto.setName("Chocolate");
        foodDto.setCategory("Dessert");
        foodDto.setDescription("");
        foodDto.setPicture("");
        service.food(foodDto, "create_food");
        
        foodDto.setCalorie(38);
        foodDto.setUnit("1 small");
        service.food(foodDto, "create_info");
        
        foodDto.setCalorie(235);
        foodDto.setUnit("1 bar");
        service.food(foodDto, "create_info");
        
        foodDto.setName("Ice Cream");
        foodDto.setCategory("Dessert");
        foodDto.setDescription("");
        foodDto.setPicture("");
        service.food(foodDto, "create_food");
        
        foodDto.setCalorie(216);
        foodDto.setUnit("100 grams");
        service.food(foodDto, "create_info");
        
        foodDto.setCalorie(286);
        foodDto.setUnit("1 cup");
        service.food(foodDto, "create_info");
        
        foodDto.setName("Beer");
        foodDto.setCategory("Beverage");
        foodDto.setDescription("");
        foodDto.setPicture("");
        service.food(foodDto, "create_food");
        
        foodDto.setCalorie(145);
        foodDto.setUnit("1 can");
        service.food(foodDto, "create_info");
        
        foodDto.setName("Fruit Shake");
        foodDto.setCategory("Beverage");
        foodDto.setDescription("");
        foodDto.setPicture("");
        service.food(foodDto, "create_food");
        
        foodDto.setCalorie(130);
        foodDto.setUnit("1 cup");
        service.food(foodDto, "create_info");
        
        foodDto.setCalorie(55);
        foodDto.setUnit("100 ml");
        service.food(foodDto, "create_info");
        
        foodDto.setName("Wine");
        foodDto.setCategory("Beverage");
        foodDto.setDescription("");
        foodDto.setPicture("");
        service.food(foodDto, "create_food");
        
        foodDto.setCalorie(83);
        foodDto.setUnit("100 grams");
        service.food(foodDto, "create_info");
        
        foodDto.setCalorie(123);
        foodDto.setUnit("5 fl. oz");
        service.food(foodDto, "create_info");
        
        foodDto.setName("Soda");
        foodDto.setCategory("Beverage");
        foodDto.setDescription("");
        foodDto.setPicture("");
        service.food(foodDto, "create_food");
        
        foodDto.setCalorie(144);
        foodDto.setUnit("1 can");
        service.food(foodDto, "create_info");
        
        foodDto.setName("Coffee");
        foodDto.setCategory("Beverage");
        foodDto.setDescription("");
        foodDto.setPicture("");
        service.food(foodDto, "create_food");
        
        foodDto.setCalorie(2);
        foodDto.setUnit("1 cup");
        service.food(foodDto, "create_info");
        
        foodDto.setName("Chips");
        foodDto.setCategory("Snacks");
        foodDto.setDescription("");
        foodDto.setPicture("");
        service.food(foodDto, "create_food");
        
        foodDto.setCalorie(150);
        foodDto.setUnit("30 grams");
        service.food(foodDto, "create_info");
        
        foodDto.setName("French Fries");
        foodDto.setCategory("Snacks");
        foodDto.setDescription("");
        foodDto.setPicture("");
        service.food(foodDto, "create_food");
        
        foodDto.setCalorie(312);
        foodDto.setUnit("1 medium");
        service.food(foodDto, "create_info");
        
        foodDto.setCalorie(408);
        foodDto.setUnit("1 large");
        service.food(foodDto, "create_info");*/
               
        return null;
    }
  

}
