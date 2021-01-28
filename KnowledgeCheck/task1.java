#include <iostream>
using namespace std;

int main ()
{
    char op;
    double a, b, res;
    cout << "Введите выражение:"<<endl;
    cin >> a >> op >> b;
    if (op == '+')
    {
        res = a + b;
    }
    
    if (op == '-')
    {
        res = a - b;
    }

    if (op == '*')
    {
         res = a * b;
    }

    if (op == '/')
    {
        if (b == 0)
            cout << "Делить на ноль нельзя";
        else res = a/b;
    }
    cout << res;
    return 0;
}
