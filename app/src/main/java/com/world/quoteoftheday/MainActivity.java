package com.world.quoteoftheday;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    ImageView next;
    ImageView save;
    ImageView share;

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);

        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        next = findViewById(R.id.next);
        save = findViewById(R.id.save);
        share = findViewById(R.id.share);

        sharedPreferences = getSharedPreferences("quote_details", MODE_PRIVATE);

        String[] quotes = {
                "Be the change you wish to see in the world.",
                "In the middle of difficulty lies opportunity.",
                "Success is not final, failure is not fatal: It is the courage to continue that counts.",
                "Believe you can and you're halfway there.",
                "The only limit to our realization of tomorrow will be our doubts of today.",
                "Don't watch the clock; do what it does. Keep going.",
                "You are never too old to set another goal or to dream a new dream.",
                "The future belongs to those who believe in the beauty of their dreams.",
                "The only way to do great work is to love what you do.",
                "Everything you can imagine is real.",
                "Simplicity is the ultimate sophistication.",
                "Life is either a daring adventure or nothing at all.",
                "Life is what happens when you're busy making other plans.",
                "To live is the rarest thing in the world. Most people exist, that is all.",
                "Success is not how high you have climbed, but how you make a positive difference to the world.",
                "The greatest glory in living lies not in never falling, but in rising every time we fall.",
                "With the new day comes new strength and new thoughts.",
                "It does not matter how slowly you go as long as you do not stop.",
                "You miss 100% of the shots you don't take.",
                "The only person you are destined to become is the person you decide to be.",
                "You become what you believe.",
                "What lies behind us and what lies before us are tiny matters compared to what lies within us.",
                "Do not go where the path may lead, go instead where there is no path and leave a trail.",
                "It always seems impossible until it is done.",
                "Believe you can and you're halfway there.",
                "I am not a product of my circumstances. I am a product of my decisions.",
                "Don't count the days, make the days count.",
                "The best way to predict the future is to create it.",
                "The only thing standing between you and your goal is the story you keep telling yourself as to why you can't achieve it.",
                "It's not whether you get knocked down, it's whether you get up.",
                "The only person you are destined to become is the person you decide to be.",
                "Life is 10% what happens to us and 90% how we react to it.",
                "The greatest glory in living lies not in never falling, but in rising every time we fall.",
                "Your time is limited, don't waste it living someone else's life.",
                "Life is what happens when you're busy making other plans.",
                "You don't have to be great to start, but you have to start to be great.",
                "The best time to plant a tree was 20 years ago. The second best time is now.",
                "The future belongs to those who believe in the beauty of their dreams.",
                "The only way to do great work is to love what you do.",
                "The best revenge is massive success.",
                "The only limit to our realization of tomorrow will be our doubts of today.",
                "The journey of a thousand miles begins with one step.",
                "You must be the change you wish to see in the world.",
                "Life is what happens when you're busy making other plans.",
                "With the new day comes new strength and new thoughts.",
                "What we think, we become.",
                "Do not wait; the time will never be 'just right.' Start where you stand, and work with whatever tools you may have at your command, and better tools will be found as you go along.",
                "Believe you can and you're halfway there.",
                "Strive not to be a success, but rather to be of value.",
                "The only way to do great work is to love what you do.",
                "The only limit to our realization of tomorrow is our doubts of today.",
                "Success is not the key to happiness. Happiness is the key to success. If you love what you are doing, you will be successful.",
                "Challenges are what make life interesting and overcoming them is what makes life meaningful.",
                "The greatest glory in living lies not in never falling, but in rising every time we fall.",
                "The way to get started is to quit talking and begin doing.",
                "Your attitude, not your aptitude, will determine your altitude.",
                "The only source of knowledge is experience.",
                "The best and most beautiful things in the world cannot be seen or even touched - they must be felt with the heart.",
                "In the end, it's not the years in your life that count. It's the life in your years.",
                "Life is about making an impact, not making an income.",
                "The only way to do great work is to love what you do.",
                "Don't be afraid to give up the good to go for the great.",
                "You can't let your failures define you. You have to let your failures teach you.",
                "People who are crazy enough to think they can change the world, are the ones who do.",
                "If you want to lift yourself up, lift up someone else.",
                "Life is like riding a bicycle. To keep your balance, you must keep moving.",
                "The only person you should try to be better than is the person you were yesterday.",
                "Life is not measured by the number of breaths we take, but by the moments that take our breath away.",
                "The only way to do great work is to love what you do.",
                "Happiness is not something ready made. It comes from your own actions.",
                "Believe you can and you're halfway there.",
                "The best way to predict the future is to create it.",
                "It's not what happens to you, but how you react to it that matters.",
                "The best time to plant a tree was 20 years ago. The second best time is now.",
                "Change your thoughts and you change your world.",
                "The only way to achieve the impossible is to believe it is possible.",
                "You are never too old to set another goal or to dream a new dream.",
                "Success is not just about making money. It's about making a difference.",
                "The purpose of our lives is to be happy.",
                "The only thing that stands between you and your dream is the will to try and the belief that it is actually possible.",
                "Life is short, and it's up to you to make it sweet.",
                "It always seems impossible until it's done.",
                "The only thing worse than being blind is having sight but no vision.",
                "The future belongs to those who believe in the beauty of their dreams.",
                "The only limit to our realization of tomorrow is our doubts of today.",
                "Believe in yourself and all that you are. Know that there is something inside you that is greater than any obstacle.",
                "Life is not about finding yourself. Life is about creating yourself.",
                "The purpose of our lives is to be happy.",
                "Success is not the key to happiness. Happiness is the key to success.",
                "The only way to do great work is to love what you do.",
                "In the end, it's not the years in your life that count. It's the life in your years.",
                "The greatest glory in living lies not in never falling, but in rising every time we fall.",
                "The only way to do great work is to love what you do.",
                "Don't be afraid to give up the good to go for the great.",
                "You can't let your failures define you. You have to let your failures teach you.",
                "People who are crazy enough to think they can change the world, are the ones who do.",
                "If you want to lift yourself up, lift up someone else.",
                "Life is like riding a bicycle. To keep your balance, you must keep moving.",
                "The only person you should try to be better than is the person you were yesterday.",
                "Life is what happens when you're busy making other plans.",
                "The only way to do great work is to love what you do.",
                "The best way to predict the future is to create it.",
                "It's not what happens to you, but how you react to it that matters.",
                "The best time to plant a tree was 20 years ago. The second best time is now.",
                "Change your thoughts and you change your world.",
                "The only way to achieve the impossible is to believe it is possible.",
                "You are never too old to set another goal or to dream a new dream.",
                "Success is not just about making money. It's about making a difference.",
                "The purpose of our lives is to be happy.",
                "The only thing that stands between you and your dream is the will to try and the belief that it is actually possible.",
                "Life is short, and it's up to you to make it sweet.",
                "It always seems impossible until it's done.",
                "The only thing worse than being blind is having sight but no vision.",
                "The future belongs to those who believe in the beauty of their dreams.",
                "Believe in yourself and all that you are. Know that there is something inside you that is greater than any obstacle.",
                "Life is not about finding yourself. Life is about creating yourself.",
                "The purpose of our lives is to be happy.",
                "Success is not the key to happiness. Happiness is the key to success.",
                "The only way to do great work is to love what you do.",
                "In the end, it's not the years in your life that count. It's the life in your years.",
                "The greatest glory in living lies not in never falling, but in rising every time we fall.",
                "The only way to do great work is to love what you do.",
                "Don't be afraid to give up the good to go for the great.",
                "You can't let your failures define you. You have to let your failures teach you.",
                "People who are crazy enough to think they can change the world, are the ones who do.",
                "If you want to lift yourself up, lift up someone else.",
                "Life is like riding a bicycle. To keep your balance, you must keep moving.",
                "The only person you should try to be better than is the person you were yesterday.",
                "It's not the load that breaks you down, it's the way you carry it.",
                "Do what you can with all you have, wherever you are.",
                "The more you praise and celebrate your life, the more there is in life to celebrate.",
                "Do not wait for leaders; do it alone, person to person.",
                "We make a living by what we get, but we make a life by what we give.",
                "Don't cry because it's over, smile because it happened.",
                "Life is not measured by the number of breaths we take, but by the moments that take our breath away.",
                "Keep your face always toward the sunshine - and shadows will fall behind you.",
                "In the end, we will remember not the words of our enemies, but the silence of our friends.",
                "The only thing we have to fear is fear itself.",
                "Life is what happens to us while we are making other plans.",
                "To be yourself in a world that is constantly trying to make you something else is the greatest accomplishment.",
                "The only true wisdom is in knowing you know nothing.",
                "Believe you can and you're halfway there.",
                "You miss 100% of the shots you don't take.",
                "The only limit to our realization of tomorrow is our doubts of today.",
                "Success is not the key to happiness. Happiness is the key to success.",
                "Believe you can and you're halfway there.",
                "The only way to do great work is to love what you do."
        };

        int randomIndex = new Random().nextInt(quotes.length);
        textView.setText(quotes[randomIndex]);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int randomIndex = new Random().nextInt(quotes.length);
                textView.setText(quotes[randomIndex]);

            }
        });

        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String quote = textView.getText().toString();
                shareQuote(quote);

            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String quote = textView.getText().toString();

                int quoteCounter = sharedPreferences.getInt("quote_counter", 0);

                int quoteNumber = quoteCounter + 1;

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("quote_" + quoteNumber + "_quote_name", quote);
                editor.putInt("quote_counter", quoteNumber); // Update task counter
                editor.apply();
                
                Intent intent = new Intent(MainActivity.this, Saved.class);
                startActivity(intent);

            }
        });

    }

    private void shareQuote(String quote) {

        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("text/plain");
        shareIntent.putExtra(Intent.EXTRA_TEXT, quote);
        startActivity(shareIntent);

    }
}