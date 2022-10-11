package com.akira.reggie;


import com.akira.reggie.common.CustomException;
import com.akira.reggie.entity.Dish;
import com.akira.reggie.entity.Setmeal;
import com.akira.reggie.service.DishService;
import com.akira.reggie.service.SetmealService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ReggieApplicationTest {
    @Autowired
    private SetmealService setmealService;

    @Autowired
    private DishService dishService;

    @Test
    public void func1(){
        //查询当前分类是否关联了套餐，如果已经关联，抛出一个业务异常
        LambdaQueryWrapper<Setmeal> setmealLambdaQueryWrapper = new LambdaQueryWrapper<>();
        //添加查询条件，根据分类id进行查询
        setmealLambdaQueryWrapper.eq(Setmeal::getCategoryId,1413386191767674881L);
        int count2 = setmealService.count();
        System.out.println("count2:"+count2);
        if(count2 > 0){
            //已经关联套餐，抛出一个业务异常
            throw new CustomException("当前分类下关联了套餐，不能删除");
        }
    }


    @Test
    public void func2(){
        LambdaQueryWrapper<Dish> dishLambdaQueryWrapper = new LambdaQueryWrapper<>();
        //添加查询条件，根据分类id进行查询
        dishLambdaQueryWrapper.eq(Dish::getCategoryId,1413386191767674881L);
        int count1 = dishService.count(dishLambdaQueryWrapper);
        System.out.println("count1:"+count1);
        //查询当前分类是否关联了菜品，如果已经关联，抛出一个业务异常
        if(count1 > 0){
            //已经关联菜品，抛出一个业务异常
            throw new CustomException("当前分类下关联了菜品，不能删除");


        }
    }
}
