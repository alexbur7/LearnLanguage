package com.example.learnlanguage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.learnlanguage.Words;
import com.example.learnlanguage.WordsDatabase;

public class AddDB extends AppCompatActivity {

    private EditText edtTranWord, edtTrueWord, edtFalseWord1, edtFalseWord2, edtFalseWord3, edtTopic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_d_b);

        edtTranWord = findViewById(R.id.edtTranWord);
        edtTrueWord = findViewById(R.id.edtTrueWord);
        edtFalseWord1 = findViewById(R.id.edtFalseWord1);
        edtFalseWord2 = findViewById(R.id.edtFalseWord2);
        edtFalseWord3 = findViewById(R.id.edtFalseWord3);
        edtTopic = findViewById(R.id.edtTopic);

        System.out.println();

        Button btnAdd = findViewById(R.id.AddDBbtn);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            Words words;

            @Override
            public void onClick(View v) {

                if(edtTranWord.getText().length() == 0){
                    Toast t = Toast.makeText(getApplicationContext(), "Введите слово на Английском!" , Toast.LENGTH_LONG);
                    t.show();
                }else{
                    /*AsyncTask.execute(new Runnable() {
                        @Override
                        public void run() {
                            try {*/
                                words = new Words(edtTranWord.getEditableText().toString() , edtTrueWord.getEditableText().toString() ,
                                        edtFalseWord1.getEditableText().toString() , edtFalseWord2.getEditableText().toString() ,
                                        edtFalseWord3.getEditableText().toString(), Integer.parseInt(edtTopic.getEditableText().toString()));
                                MainActivity.newDatabase().getWordsDao().insertWords(words);
                           // }catch (Exception e){
                               // Toast t = Toast.makeText(getApplicationContext(), "Что-то пошло не так", Toast.LENGTH_SHORT);
                          //  }

                      //  }
                   // });
                    Toast toastShow = Toast.makeText(getApplicationContext(), "Загрузка прошла успешно" , Toast.LENGTH_SHORT);
                    toastShow.show();
                    edtTranWord.setText("");
                    edtTrueWord.setText("");
                    edtFalseWord1.setText("");
                    edtFalseWord2.setText("");
                    edtFalseWord3.setText("");
                    edtTopic.setText("");
                }
            }
        });
    }


   /* private List<Words> createWords() {

        List<Words> words = new ArrayList<>(49);
        //*********************************************************Тело(15 слов)*******************************************************************
        words.add(new Words("Chest", "Грудь","Колено","Шея","Локоть",1));
        words.add(new Words("Arm", "Рука","Грудь","Талия","Палец",1));
        words.add(new Words("Knee", "Колено","Шея","Волосы","Глаз",1));
        words.add(new Words("Foot", "Ступня","Бедро","Пятка","Локоть",1));
        words.add(new Words("Shoulder", "Плечо","Бровь","Нос","Бедро",1));
        words.add(new Words("Neck", "Шея","Нога","Рука","Голова",1));
        words.add(new Words("Waist", "Талия","Голова","Нос","Зуб",1));
        words.add(new Words("Hand", "Рука","Колено","Ступня","Плечо",1));
        words.add(new Words("Finger", "Палец","Нос","Нога","Голова",1));
        words.add(new Words("Leg", "Нога","Бедро","Бровь","Зуб",1));
        words.add(new Words("Hair", "Волосы","Колено","Шея","Локоть",1));
        words.add(new Words("Eyebrow", "Бровь","Голова","Нос","Плечо",1));
        words.add(new Words("Nose", "Нос","Шея","Ступня","Зуб",1));
        words.add(new Words("Head", "Голова","Рука","Плечо","Колено",1));
        words.add(new Words("Tooth", "Зуб","Палец","Грудь","Бедро",1));
        //*******************************************************Насекомые(12 слов)****************************************************************
        words.add(new Words("Bee", "Пчела","Оса","Кузнечик","Жук",2));
        words.add(new Words("Wasp", "Оса","Бабочка","Муха","Таракан",2));
        words.add(new Words("Bumblebee", "Шмель","Пчела","Гусеница","Стрекоза",2));
        words.add(new Words("Grasshopper", "Кузнечик","Гусеница","Оса","Паук",2));
        words.add(new Words("Spider", "Паук","Бабочка","Пчела","Комар",2));
        words.add(new Words("Bug", "Жук","Шмель","Таракан","Муха",2));
        words.add(new Words("Fly", "Муха","Кузнечик","Шмель","Оса",2));
        words.add(new Words("Dragonfly", "Стрекоза","Муха","Бабочка","Оса",2));
        words.add(new Words("Cockroach", "Таракан","Паук","Шмель","Пчела",2));
        words.add(new Words("Mosquito", "Комар","Оса","Стрекоза","Гусеница",2));
        words.add(new Words("Caterpillar", "Гусеница","Кузнечик","Жук","Таракан",2));
        words.add(new Words("Butterfly", "Бабочка","Оса","Муха","Шмель",2));
        //************************************************************Еда(10 слов)*****************************************************************
        words.add(new Words("Egg", "Яйцо","Сок","Орехи","Чипсы",3));
        words.add(new Words("Milk", "Молоко","Слива","Дыня","Картошка",3));
        words.add(new Words("Orange", "Апельсин","Орехи","Сок","Чипсы",3));
        words.add(new Words("Plum", "Слива","Морковь","Чипсы","Молоко",3));
        words.add(new Words("Melon", "Дыня","Слива","Картошка","Яйцо",3));
        words.add(new Words("Carrot", "Морковь","Сок","Орехи","Дыня",3));
        words.add(new Words("Potato", "Картошка","Чипсы","Морковь","Молоко",3));
        words.add(new Words("Juice", "Сок","Картошка","Слива","Яйцо",3));
        words.add(new Words("Nuts", "Орехи","Апельсин","Дыня","Картошка",3));
        words.add(new Words("Crisps", "Чипсы","Сок","Орехи","Морковь",3));
        //************************************************************Погода(13 слов)**************************************************************
        words.add(new Words("Rain", "Дождь","Туман","Солнце","Сиять",4));
        words.add(new Words("Snow", "Снег","Сверкать","Молния","Мороз",4));
        words.add(new Words("Storm", "Уроган","Ветер","Гроза","Солнце",4));
        words.add(new Words("Cold", "Холодный","Жара","Солнце","Туман",4));
        words.add(new Words("Frost", "Мороз","Молния","Дождь","Снег",4));
        words.add(new Words("Thunder", "Гроза","Сверкать","Сиять","Холодный",4));
        words.add(new Words("Heat", "Жара","Солнце","Ветер","Туман",4));
        words.add(new Words("Shine", "Сиять","Дождь","Сверкать","Молния",4));
        words.add(new Words("Wind", "Ветер","Ураган","Мороз","Гроза",4));
        words.add(new Words("Lightning", "Молния","Жара","Солнце","Холодный",4));
        words.add(new Words("Fog", "Туман","Снег","Сиять","Ветер",4));
        words.add(new Words("Sparkle", "Сверкать","Дождь","Молния","Ураган",4));
        words.add(new Words("Sun", "Солнце","Гроза","Туман","Холодный",4));

        return words;
    }

    */
}