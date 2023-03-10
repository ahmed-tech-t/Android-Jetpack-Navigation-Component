package com.example.nav_graph

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.nav_graph.databinding.FragmentChooseRecipientBinding

class ChooseRecipientFragment : Fragment() ,OnClickListener {

    /**declare all variables**/
    private lateinit var binding: FragmentChooseRecipientBinding
    private var navController:NavController? = null

    /**onCreateView**/
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding =  FragmentChooseRecipientBinding.inflate(inflater,container,false)
        setListenersToButtons()
        return binding.root
    }


    /**onViewCreated**/
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view , savedInstanceState)
        navController =  Navigation.findNavController(view)
    }


    /**set all Listeners to clicked Items**/
    private fun setListenersToButtons() {
        binding.nextBtn.setOnClickListener(this)
        binding.cancelBtn.setOnClickListener(this)
    }

    /**onClick Function**/
    override fun onClick(v: View?) {
        when(v?.id){
            binding.nextBtn.id -> {
                binding.apply {
                    if(!TextUtils.isEmpty(inputRecipient.text)) {
                        val action = ChooseRecipientFragmentDirections.actionChooseRecipientFragmentToSpecifyAmountFragment(inputRecipient.text.toString())
                        navController!!.navigate(action)
                    }else inputRecipient.error = "can't be empty"
                }
            }
            binding.cancelBtn.id -> navController!!.popBackStack()
        }
    }

}