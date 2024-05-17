#include <iostream>
class Parent {
    public:
    void f() { std::cout << "Parent\n"; }
};
class Child : public Parent {
    public:
    void f() { std::cout << "Child\n"; }
};
int main() {
    Child obj;
    obj.f();
    Parent *p = &obj;
    p->f();
}