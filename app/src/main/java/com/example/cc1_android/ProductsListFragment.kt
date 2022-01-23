package com.example.cc1_android

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class ProductsListFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(
            R.layout.fragment_products_list,
            container,
            false
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val productsList = listOf<Product>(Product("Petits pois et Carottes","Cassegrain","123456","Aucun","20",listOf("Aucun"),listOf("Aucun"),
            listOf("Aucun"),listOf("France", "Algeria", "Japon"),R.drawable.placeholder),Product("Petits pois et Carottes","Cassegrain","123456","Aucun","20",listOf("Aucun"),listOf("Aucun"),
            listOf("Aucun"),listOf("France", "Algeria", "Japon"),R.drawable.placeholder),Product("Petits pois et Carottes","Cassegrain","123456","Aucun","20",listOf("Aucun"),listOf("Aucun"),
            listOf("Aucun"),listOf("France", "Algeria", "Japon"),R.drawable.placeholder))
        view.findViewById<RecyclerView>(R.id.recyclerView).run{
            adapter = RecyclerAdapter(
                productsList,
                listener = object : OnItemClickedListener {
                    override fun onItemClicked(position: Int) {
                        Log.d("position", position.toString())
                        findNavController().navigate(
                            ProductsListFragmentDirections.actionProductsListFragmentToProductDetailsFragment(
                                productsList[position]
                            )
                        )
                    }
                }
            )
            layoutManager = GridLayoutManager(requireContext(),1)
        }
    }
}