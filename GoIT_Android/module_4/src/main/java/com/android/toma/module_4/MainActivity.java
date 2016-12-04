package com.android.toma.module_4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Toast;

import com.android.toma.module_4.ticTacToe.Game;
import com.android.toma.module_4.ticTacToe.Player;
import com.android.toma.module_4.ticTacToe.Square;

public class MainActivity extends AppCompatActivity {

    private Game game;
    private Button[][] buttons = new Button[3][3];
    private TableLayout tableLayout;


    public MainActivity() {
        game = new Game();
        game.start();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tableLayout = (TableLayout) findViewById(R.id.activity_main);
        buildGameField();
    }

    private void buildGameField() {
        Square[][] field = game.getField();
        for (int i = 0, lenI = field.length; i < lenI; i++ ) {
            TableRow row = new TableRow(this);
            for (int j = 0, lenJ = field[i].length; j < lenJ; j++) {
                Button button = new Button(this);
                buttons[i][j] = button;
                button.setOnClickListener(new Listener(i, j)); // установка слушателя, реагирующего на клик по кнопке
                row.addView(button, new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,
                        TableRow.LayoutParams.WRAP_CONTENT)); // добавление кнопки в строку таблицы
                button.setWidth(107);
                button.setHeight(107);
            }
            tableLayout.addView(row, new TableLayout.LayoutParams(TableLayout.LayoutParams.WRAP_CONTENT,
                    TableLayout.LayoutParams.WRAP_CONTENT)); // добавление строки в таблицу
        }
    }

    public class Listener implements View.OnClickListener {
        private int x = 0;
        private int y = 0;

        public Listener(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public void onClick(View view) {
            Button button = (Button) view;
            Game g = game;
            Player player = g.getCurrentActivePlayer();
            if (makeTurn(x, y)) {
                button.setText(player.getName());
            }
            Player winner = g.checkWinner();
            if (winner != null) {
                gameOver(winner);
            }
            if (g.isFieldFilled()) {  // в случае, если поле заполнено
                gameOver();
            }
        }
    }

    private boolean makeTurn(int x, int y) {
        return game.makeTurn(x, y);
    }

    private void gameOver(Player player) {
        CharSequence text = "Player \"" + player.getName() + "\" won!";
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
        game.reset();
        refresh();
    }

    private void gameOver() {
        CharSequence text = "Draw";
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
        game.reset();
        refresh();
    }

    private void refresh() {
        Square[][] field = game.getField();

        for (int i = 0, len = field.length; i < len; i++) {
            for (int j = 0, len2 = field[i].length; j < len2; j++) {
                if (field[i][j].getPlayer() == null) {
                    buttons[i][j].setText("");
                } else {
                    buttons[i][j].setText(field[i][j].getPlayer().getName());
                }
            }
        }
    }
}
