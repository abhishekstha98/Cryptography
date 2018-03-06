#include <iostream>
using namespace std;
int decrypt(string,int);
int encrypt(string a, int k){
    char b[a.size()],d[a.size()];
    for(int i =0 ; i<a.size();i++){
        b[i]=a[i];
    }
    for(int i =0 ; i<a.size();i++){
        if(b[i]==' '){
            continue;
        }else {
            int c = (int) b[i] - 97;
            d[i] = (char) (((c + k) % 26) + 97);
        }
    }
    cout<<"After encryption : ";
    for(int i =0 ; i<a.size();i++){
        cout<<d[i];
    }
    cout<<endl;
    cout<<"Would you like to decrypt again?"<<endl;
    char as;
    cin>>as;
    if(as=='y' || as == 'Y'){
        for(int i =0 ; i<a.size();i++){
            a[i]=d[i];
        }
        decrypt(a,k);
    }
    else{
        return 0;
    }
    return 0;
}
int decrypt(string a, int k){
    cout<<"before decryption : "<< a<<endl;
    char b[a.size()],d[a.size()];
    for(int i =0 ; i<a.size();i++){
        b[i]=a[i];
    }
    for(int i =0 ; i<a.size();i++){
        if(b[i]==' '){
            continue;
        }else {
            int c = (int) b[i] - 97;
            d[i] = (char) (((c - k) % 26) + 97);
        }
    }
    cout<<"After decryption : ";
    for(int i =0 ; i<a.size();i++){
        cout<<d[i];
    }
    return 0;
}
int main() {
    string a;
    int k,opt;
    cout<<"Enter the option : "<<endl;
    cout<<"1. Encryption"<<endl;
    cout<<"2. Decryption"<<endl;
    cout<<"3. Exit"<<endl;
    cin>>opt;
    cout<<"Enter the key!"<<endl;
    cin>>k;
    switch (opt) {
        case 1:
            cout << "Enter the text to encrypt!" << endl;
            cin >> a;
            encrypt(a,k);
            break;
        case 2:
            cout << "Enter the text to decrypt!" << endl;
            cin >> a;
            decrypt(a,k);
            break;
        case 3:
            return 0;
        default:
            return 0;
    }
    return 0;
}