package com.example.nav_graph

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.nav_graph.databinding.FragmentMainBinding

class MainFragment : Fragment() , OnClickListener{

    /**declare all variables**/
    private var navController :NavController? = null
    private lateinit var binding : FragmentMainBinding


    /**onCreateView**/
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentMainBinding.inflate(inflater,container,false)
        setListenersToButtons()
        return binding.root
    }


    /**onViewCreated**/
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //initialize navigation controller
        navController = Navigation.findNavController(view)
    }

    /**set all Listeners to clicked Items**/
    private fun setListenersToButtons() {
        binding.sendMoneyBtn.setOnClickListener(this)
        binding.viewBalanceBtn.setOnClickListener(this)
        binding.viewTransactionsBtn.setOnClickListener(this)
    }

    /**onClick Function**/
    override fun onClick(v: View?) {
        when (v?.id){
            binding.sendMoneyBtn.id ->{
                val action = MainFragmentDirections.actionMainFragmentToChooseRecipientFragment()
                navController!!.navigate(action)
            }
            binding.viewBalanceBtn.id -> {
                val action = MainFragmentDirections.actionMainFragmentToViewBalanceFragment()
                navController!!.navigate(action)
            }
            binding.viewTransactionsBtn.id -> {
                val action = MainFragmentDirections.actionMainFragmentToViewTransactionFragment()
                navController!!.navigate(action)
            }
        }
    }
}