#include <iostream>
#include <string.h>
using namespace std;
int contains(string a,char b){
    for(int i=0;i<a.size();i++){
        if(a[i]==b){
            return 1;
        }
        else{
            continue;
        }
    }
    return 0;
}
int main() {
    string c_txt,c1_txt="w";
    cout<<"Enter the phrase from which cipher is to be derived : ";
    cin>>c_txt;
    for(int i=0;i<c_txt.size();i++){
        if(!contains(c1_txt,c_txt[i])){
            c1_txt[i]=c_txt[i];
        }
    }
    return 0;
}