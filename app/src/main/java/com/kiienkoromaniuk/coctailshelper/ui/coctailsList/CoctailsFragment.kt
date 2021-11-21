package com.kiienkoromaniuk.coctailshelper.ui.coctailsList

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.kiienkoromaniuk.coctailshelper.data.models.Drink
import com.kiienkoromaniuk.coctailshelper.databinding.FragmentCoctailListBinding
import dagger.hilt.android.AndroidEntryPoint
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


@AndroidEntryPoint
class CoctailsFragment : Fragment() {

    private val TAG="CoctailsFragment"

    private var columnCount = 1
    private val viewModel: CoctailsViewModel by viewModels()

    private var _binding: FragmentCoctailListBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            columnCount = it.getInt(ARG_COLUMN_COUNT)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCoctailListBinding.inflate(inflater, container, false)
        Log.d(TAG, "onCreateView")
        return binding.root
    }
    override fun onDestroyView() {
        Log.d(TAG, "onDestroyVIew")
        super.onDestroyView()
        _binding = null
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Log.d(TAG, "onViewCreated")
        getCoctails()
        super.onViewCreated(view, savedInstanceState)
    }
    private fun getCoctails(){
        Log.d(TAG, "get coctails")
        val single =viewModel.getCoctails("Alcoholic").subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .map {
                return@map it.drinks
            }.subscribe(
                {
                    Log.d(TAG, "subscribe: onSuccess")
                    setAdapter(it)
                },{
                    Log.e(TAG, it.toString())
            }
        )

    }
    private fun setAdapter(items: List<Drink>){
        val view = binding.root

        // Set the adapter
        with(view) {
            layoutManager = when {
                columnCount <= 1 -> LinearLayoutManager(context)
                else -> GridLayoutManager(context, columnCount)
            }
            adapter = CoctailsRecyclerViewAdapter(items,requireContext())
        }
    }
    companion object {

        // TODO: Customize parameter argument names
        const val ARG_COLUMN_COUNT = "column-count"

        // TODO: Customize parameter initialization
        @JvmStatic
        fun newInstance(columnCount: Int) =
            CoctailsFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_COLUMN_COUNT, columnCount)
                }
            }
    }
}