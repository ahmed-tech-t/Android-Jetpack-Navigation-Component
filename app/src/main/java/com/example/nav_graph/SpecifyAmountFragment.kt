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
import androidx.navigation.fragment.navArgs
import com.example.nav_graph.databinding.FragmentSpecifyAmountBinding
import com.example.nav_graph.models.Money
import java.math.BigDecimal

class SpecifyAmountFragment : Fragment() ,OnClickListener {

    /**declare all variables**/
    private lateinit var binding: FragmentSpecifyAmountBinding
    private var navController: NavController? = null
    private val args : SpecifyAmountFragmentArgs by navArgs()

    /**onCreateView**/
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding =  FragmentSpecifyAmountBinding.inflate(inflater,container,false)
        setListenersToButtons()
        return binding.root
    }


    /**onViewCreated**/
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view , savedInstanceState)
        navController =  Navigation.findNavController(view)
        setDataToView()
    }


    /**set all Listeners to clicked Items**/
    private fun setListenersToButtons() {
        binding.sendBtn.setOnClickListener(this)
        binding.cancelBtn.setOnClickListener(this)
    }

    /**set data to view**/
    private fun setDataToView(){
        binding.recipientVar = args.recipient
    }

    /**onClick Function**/
    override fun onClick(v: View?) {
        when(v?.id){
            binding.sendBtn.id -> {
                binding.apply {
                    if (!TextUtils.isEmpty(inputAmount.text)){
                        val action =
                            SpecifyAmountFragmentDirections.actionSpecifyAmountFragmentToConfirmationFragment(
                                Money(BigDecimal(inputAmount.text.toString())),
                                args.recipient
                            )
                        navController!!.navigate(action)
                    }else{
                        inputAmount.error = "can't be empty"
                    }
                }
            }
            binding.cancelBtn.id -> navController!!.popBackStack()
        }
    }

}