#include<iostream>
#include<stdio.h>
#include<stdlib.h>
#include<string.h>
using namespace std;
int line = 0,end1 = 0;
struct NFA{
    string s;
    string a;
    string b;
}nfa[20];
struct DFA{
    string news;
    string newa;
    string newb;
    char ch;
}dfa[20];
void scan()
{
    for(line = 0 ;; line++){
        nfa[line].a="";
        nfa[line].b="";
        cin>>nfa[line].s;

        string mida;
        cin>>mida;
        for(int j = 0;j<mida.length();j++){
            if(mida[j]=='{'||mida[j]==','||mida[j]=='}'||mida[j]==' '){
                continue;
            }
            else{
                if(mida[j]=='N'){
                    nfa[line].a="";
                    break;
                }
                else{
                    nfa[line].a+= mida[j];
                }
            }
        }
        string midb;
        cin>>midb;
        for(int j = 0;j<midb.length();j++){
            if(midb[j]=='{'||midb[j]==','||midb[j]=='}'||midb[j]==' '){
                continue;
            }
            else{
                if(midb[j]=='N'){
                    nfa[line].b="";
                    break;
                }
                else{
                    nfa[line].b+= midb[j];
                }
            }
        }
        if(nfa[line].s=="f")
            break;
    }
}
string clean(string next){
    int n=0,m=0;
    string str="";
    str+=next[0];
    for(n=0;n<next.length();n++){
        for(m=0;m<str.length();m++)
        {
            if(next[n]==str[m])
                break;
        }
        if(m>=str.length())
            str+=next[n];
    }
    return str;
}
void change()
{
    int p = 0,i=0;
    dfa[0].news = nfa[0].s;
    for(p=0;p<=end1;p++){
        dfa[p].newa="";
        dfa[p].newb="";
        if(dfa[p].news.length()==1){
            for(int j = 0;j<=line;j++){
                if(dfa[p].news==nfa[j].s){
                        dfa[p].newa = nfa[j].a;
                        dfa[p].newb = nfa[j].b;
                        }
                }
        }else{
            dfa[p].newb="";
            string ll="";
            for(int l = 0;l<dfa[p].news.length();l++)
            {
                for(int j = 0;j<=line;j++){
                    if(dfa[p].news[l]==nfa[j].s[0]){
                        dfa[p].newa+=nfa[j].a;
                        ll+= nfa[j].b;
                        dfa[p].newb=ll;
                    }
                }
                    dfa[p].newa = clean(dfa[p].newa);
                    dfa[p].newb = clean(dfa[p].newb);
            }
        }
        for(i = 0;i<=end1;i++){
            if(dfa[p].newa==dfa[i].news){
                break;
            }
        }
        if(i>end1){
            if(dfa[p].newa!=""){
            end1++;
            dfa[end1].news = dfa[p].newa;
            }
        }
        for(i = 0;i<=end1;i++){
            if(dfa[p].newb==dfa[i].news){
                break;
            }
        }
            if(i>end1){
                if(dfa[p].newb!=""){
                end1++;
                dfa[end1].news = dfa[p].newb;
                }
            }
        if(p==end1)
            break;
    }
}
void big_change(){
    int x = 0;
    for(int i = 0;i<=end1;i++){
        dfa[i].ch='A'+i;
        if(dfa[i].news.length()==1)
            cout<<'{'<<dfa[i].news<<'}';
        else {
                cout<<'{';
            for(int n =0;n<dfa[i].news.length();n++)
                    cout<<dfa[i].news[n]<<',';
            cout<<'}';
        }
        cout<<dfa[i].ch;
        for(x=0;x<=end1;x++){
            if(dfa[i].newa==dfa[x].news){
                cout<<char('A'+x);
            }
        }
        for(x=0;x<=end1;x++){
            if(dfa[i].newb==dfa[x].news){
                cout<<char('A'+x);
            }
        }
        cout<<endl;
    }
}
int main()
{
    scan();
    change();
    big_change();
}
