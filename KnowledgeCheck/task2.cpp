#include <iostream>
using namespace std;

int main ()
{
    string s;
    int a = 0, b = 0;
    cout << "Введите слово: "<<endl;
    cin >> s;
    for (int i = 0; i<s.length();i++)
    {
        if (s[i]=='a'||s[i]=='e'||s[i]=='i'||s[i]=='o'||s[i]=='u')
            a++;
    }
    
    b = s.length()-a;

    cout << "Количество гласных: " << a << endl << "Количество согласных: " << b;
}
