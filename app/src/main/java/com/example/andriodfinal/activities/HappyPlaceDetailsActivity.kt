package com.example.andriodfinal.activities

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.andriodfinal.R
import com.example.andriodfinal.models.HappyPlaceModel
import kotlinx.android.synthetic.main.activity_happy_place_details.*

class HappyPlaceDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_happy_place_details)

        var happyPlaceDetailsModel: HappyPlaceModel? = null

        if (intent.hasExtra(MainActivity.EXTRA_PLACE_DETAILS)) {
            happyPlaceDetailsModel = intent.getParcelableExtra(MainActivity.EXTRA_PLACE_DETAILS) as HappyPlaceModel?
        }

        if (happyPlaceDetailsModel != null) {
            setSupportActionBar(toolbar_happy_place_detail) // Use the toolbar to set the action bar.
            supportActionBar?.setDisplayHomeAsUpEnabled(true) // This is to use the home back button.
            supportActionBar?.title = happyPlaceDetailsModel.title // Set the title
            // Setting the click event to the back button
            toolbar_happy_place_detail.setNavigationOnClickListener {
                onBackPressed()
            }

            // Populate rest of the fields
            iv_place_image_details.setImageURI(Uri.parse(happyPlaceDetailsModel.image))
            tv_description.text = happyPlaceDetailsModel.description
            tv_location.text = happyPlaceDetailsModel.location

            btn_view_on_map.setOnClickListener{
                val intent = Intent(this, MapActivity::class.java)
                intent.putExtra(MainActivity.EXTRA_PLACE_DETAILS, happyPlaceDetailsModel)
                startActivity(intent)
            }
        }
    }
}