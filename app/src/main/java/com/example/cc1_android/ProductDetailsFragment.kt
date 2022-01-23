package com.example.cc1_android

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.navArgs

import kotlinx.android.synthetic.main.fragment_product_details.*


class ProductDetailsFragment : Fragment() {
    private val args:ProductDetailsFragmentArgs by navArgs()
    private lateinit var product : Product
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_product_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val navHostFragment = childFragmentManager.findFragmentById(R.id.product_details_nav_host) as NavHostFragment
        //  NavigationUI.setupWithNavController(product_details_bottom_nav,navHostFragment.navController)
        val navController = navHostFragment.navController

        navController.setGraph(R.navigation.nav_details, arguments)
        var productDetailsSummary = ProductDetailsSummaryFragment()
        productDetailsSummary.arguments = arguments
        var productDetailsNutrition = ProductDetailsNutritionFragment()
        productDetailsNutrition.arguments = arguments
        var productDetailsNutritionalValues = ProductDetailsNutritionalValuesFragment()
        productDetailsNutritionalValues.arguments = arguments

        val productDetailsSummaryFragment : View = view.findViewById(R.id.productDetailsSummaryFragment)
        val productDetailsNutritionFragment : View = view.findViewById(R.id.productDetailsNutritionFragment)
        val productDetailsNutritionalValuesFragment : View = view.findViewById(R.id.productDetailsNutritionalValuesFragment)
        productDetailsSummaryFragment.setBackgroundResource(R.color.toolbar_gradient_end)

        product_details_bottom_nav.setOnNavigationItemSelectedListener { menu ->
            when (menu.itemId) {
                R.id.productDetailsFragment -> productDetailsSummaryFragment.setBackgroundResource(
                    R.color.toolbar_gradient_end)
                R.id.productDetailsNutritionFragment -> productDetailsNutritionFragment.setBackgroundResource(
                    R.color.toolbar_gradient_end)
                R.id.productDetailsNutritionalValuesFragment -> productDetailsNutritionalValuesFragment.setBackgroundResource(
                    R.color.toolbar_gradient_end)
                else -> throw Exception()
            }
            if(R.id.productDetailsFragment != menu.itemId){
                productDetailsSummaryFragment.setBackgroundColor(Color.WHITE)
            }
            if(R.id.productDetailsNutritionFragment != menu.itemId){
                productDetailsNutritionFragment.setBackgroundColor(Color.WHITE)
            }
            if(R.id.productDetailsNutritionalValuesFragment != menu.itemId){
                productDetailsNutritionalValuesFragment.setBackgroundColor(Color.WHITE)
            }

            childFragmentManager.beginTransaction()
                .replace(
                    R.id.product_details_nav_host,
                    when (menu.itemId) {
                        R.id.productDetailsFragment -> productDetailsSummary
                        R.id.productDetailsNutritionFragment -> productDetailsNutrition
                        R.id.productDetailsNutritionalValuesFragment -> productDetailsNutritionalValues
                        else -> throw Exception()
                    },
                    when (menu.itemId) {
                        R.id.productDetailsFragment -> productDetailsSummary.tag
                        R.id.productDetailsNutritionFragment -> productDetailsNutrition.tag
                        R.id.productDetailsNutritionalValuesFragment -> productDetailsNutritionalValues.tag
                        else -> throw Exception()
                    }
                )
                .commitAllowingStateLoss()
            true
        }

    }


}