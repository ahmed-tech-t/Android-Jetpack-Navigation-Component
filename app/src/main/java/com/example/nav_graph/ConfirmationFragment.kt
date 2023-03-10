package com.example.nav_graph

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.nav_graph.R
import com.example.nav_graph.databinding.FragmentConfirmationBinding

class ConfirmationFragment : Fragment() {
   private lateinit var binding :FragmentConfirmationBinding
   private val  args :ConfirmationFragmentArgs by navArgs()


    /**onCreateView**/
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding= FragmentConfirmationBinding.inflate(inflater,container,false)

        return binding.root
    }

    /**onViewCreated**/

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setDataToView()
    }


    /**set data to view**/
    private fun setDataToView(){
        binding.apply {
            amountVar = args.amount.amount.toString()
            recipientVar = args.recipient
        }
    }

}