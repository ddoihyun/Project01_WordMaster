import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class WordCRUD implements ICRUD{
    static ArrayList<Word> list;
    Scanner s;
    static final String fname = "src/main/Dictionary.txt";

    WordCRUD(Scanner s){
        list = new ArrayList<>();
        this.s = s;}

    // 1. 모든 단어 보기 기능
    public void listAll() {
        System.out.println("----------------------------------");
        for(int i=0; i<list.size(); i++) {
            System.out.print((i+1) + " ");
            System.out.println(list.get(i).toString());}
        System.out.println("----------------------------------");}

    public ArrayList<Integer> listAll(String keyword) {
        ArrayList<Integer> idlist = new ArrayList<>();
        int j = 0;

        System.out.println("----------------------------------");
        for(int i=0; i<list.size(); i++) {
            String word = list.get(i).getWord();
            if(!word.contains(keyword)) continue;
            System.out.print((j+1) + " ");
            System.out.println(list.get(i).toString());
            idlist.add(i);
            j++;}
        System.out.println("----------------------------------");
        return idlist;}

    public void listAll(int level){
        int j = 0;
        System.out.println("----------------------------------");
        for(int i=0; i<list.size(); i++) {
            int ilevel = list.get(i).getLevel();
            if(ilevel != level) continue;
            System.out.print((j+1) + " ");
            System.out.println(list.get(i).toString());
            j++;}
        System.out.println("----------------------------------");}

    // 2. 수준별 단어 보기 기능
    public void searchLevel() {
        System.out.print("=> 원하는 레벨은? (1~3) ");
        int level = s.nextInt();
        listAll(level);}

    // 3. 단어 검색 기능
    public void searchWord() {
        System.out.print("=> 원하는 단어는? ");
        String keyword = s.next();
        listAll(keyword);}

    // 4. 단어 추가 기능
    @Override
    public Object add() {
        System.out.print("=> 난이도(1,2,3) & 새 단어 입력 : ");
        int level = s.nextInt(); // 난이도 입력
        String word = s.nextLine(); // 단어 입력

        System.out.print("뜻 입력 : ");
        String meaning = s.nextLine();

        return new Word(0, level, word, meaning);}

    public void addItem(){
        Word one = (Word)add();
        list.add(one);
        System.out.println("새 단어가 단어장에 추가되었습니다.");}


    // 5. 단어 수정 기능
    public void updateItem() {
        System.out.print("=> 수정할 단어 검색 : ");
        String keyword = s.next();
        ArrayList<Integer> idlist = this.listAll(keyword);
        System.out.print("=> 수정할 번호 검색 : ");
        int id = s.nextInt();
        s.nextLine(); // id 뒤 enter 지우기 위함.
        System.out.print("=> 뜻 입력 : ");
        String meaning = s.nextLine();
        Word word = list.get(idlist.get(id-1));
        word.setMeaning(meaning);  // 의미 변경하기
        System.out.println("단어가 수정되었습니다.");}


    @Override
    public int update(Object obj) {
        return 0;
    }


    // 6. 단어 삭제 기능
    public void deleteItem() {
        System.out.print("=> 삭제할 단어 검색 : ");
        String keyword = s.next();
        ArrayList<Integer> idlist = this.listAll(keyword);
        System.out.print("=> 삭제할 번호 검색 : ");
        int id = s.nextInt();
        s.nextLine(); // id 뒤 enter 지우기 위함.
        System.out.print("=> 정말로 삭제하실래요?(Y/n) ");
        String answer = s.next();
        Word word = list.get(idlist.get(id-1));

        if(answer.equalsIgnoreCase("Y")){
            list.remove((int)idlist.get(id-1));  // remove: 객체/인덱스 번호
            System.out.println("단어가 삭제되었습니다.");}
        else
            System.out.println("취소되었습니다.");}

    @Override
    public int delete(Object obj) {return 0;}

    @Override
    public void selectOne(int id) {}

    public static void loadFile() throws IOException {
        try {
            BufferedReader br = new BufferedReader(new FileReader(fname));
            String line;
            int count = 0;  // 줄 수

            while(true){
                line = br.readLine();  // 한 줄씩 불러오기
                if(line == null) break;
                String data[] = line.split("\\|");
                int level = Integer.parseInt(data[0]);
                String word = data[1];
                String meaning = data[2];
                list.add(new Word(0, level, word, meaning));
                count++;}

            br.close();
            System.out.println("==> "+count+"개 로딩 완료!!!");}
        catch (IOException e) {
            e.printStackTrace();}}


    // 7. 파일 저장하기 기능
    public void saveFile() throws IOException {
        try{
            PrintWriter pr =  new PrintWriter(new FileWriter("test.txt")); // 파일 name에 fname 입력
            for(Word one : list){
                pr.write(one.toFileString() + "\n");}
            System.out.println("==> 데이터 저장 완료 !!!");
            pr.close();}
        catch (IOException e){
            e.printStackTrace();}}
}
