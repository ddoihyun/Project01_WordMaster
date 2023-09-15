# **# Project1: WordMaster**<br/>
<br/>
### Program 설명<br/>
#### 제작 목적: Java는 객체지향 프로그래밍 언어로서, 프로그램을 모듈화하고 관리하게 용이하다. 단어장 프로그램은 다양한 객체(예: 단어 등)이 필요하거나 구성될 수 있고, 객체지향 프로그래밍 원칙을 적용하여 코드를 보다 체계적으로 작성할 수 있다. 구현된 기능과 객체는 대학생이 많이 접하고 사용할 수 있는 단어장 프로그램으로 하였다. 이 프로젝트를 통해 객체지향 프로그램, interface 등 자바프로그래밍 언어의 특징을 이해하고 GitHub 사용을 익히는 데에 목적이 있다.<br/>
<br/>
#### 개발 환경: IDE – InteliJ / JDK – Orackle 17 version / OS – Mac OS Big Sur<br/>
<br/>
#### 구현한 기능 목록과 설명: 단어장의 CRUD 기능을 구현<br/>
1.	Create: WordCRUD.add(), WordCRUD.addItem(), WordCRUD.saveFile()<br/>
2.	Read: WordCRUD.listAll(), WordCRUD.listAll(int level), WordCRUD.loadFile()<br/>
3.	Update: WordCRUD.updateItem()<br/>
4.	Delete: WordCRUD.deleteItem()<br/>
<br/><br/>
### 개발세부사항<br/>
#### 프로그램에서 사용한 Java class 목록과 사용 내용 (in JDK)<br/>
1.	java.io*: Java에서 입력과 출력 관련 작업을 수행하기 위한 클래스와 인터페이스를 제공하는 패키지. <br/>
  i.	FileReader: 파일에서 문자 데이터를 읽을 때 사용된다. WordCRUD 클래스의 loadFile()에서 사용<br/>
  ii.	BuffferedReader: DataInputStream을 버퍼링하여 loadFile()에서 사용<br/>
  iii.	FileWriter: WordCRUD 클래스의 saveFile()에서 파일에 문자 데이터를 쓸 때 사용<br/>
  iv.	PrintWriter: WordCRUD 클래스의 saveFile()에서 텍스트 데이터를 출력할 때 사용<br/>
  v.	IOException: WordCRUD 클래스의 loadFIle()와 saveFIle()에서 입출력 작업 중 발생할 수 있는 예외를 처리하기 위한 예외 클래스<br/>
2.	java.util.ArrayList: 동적 배열 구조의 클래스. <br/>
3.	java.util.Scanner: 데이터를 읽기 위한 클래스. next(), nextInt(), nextLine()과 같은 method를 사용하여 다양한 데이터 유형을 읽는다.<br/>
  i.	Word 객체를 저장하는 List라는 이름의 ArrayList 객체 선언<br/>
<br/>
####	프로그램에서 새로 만든 Java class / Interface 목록과 설명<br/>
1.	ICRUD : CRUD를 위한 interface<br/>
2.	Word : 데이터클래스<br/>
3.	WordCRUD : ICRUD interface 구현제<br/>
  i.	listAll(): 모든 단어 보기 기능. list를 한 줄씩 출력<br/>
  ii.	listAll(String keyword): 단어 검색 기능. 문자를 입력하면 해당하는 문자가 있는 단어 ArrayList 출력<br/>
  iii.	listAll(int level): 레벨 검색 기능. 레벨을 입력하면 레벨에 해당하는 단어 list를 출력<br/>
  iv.	searchLevel(): 수준별 단어 보기 기능. listAll(int level) method를 이용하여 해당 list를 출력<br/>
  v.	add(): 단어 추가 기능. 난이도와 단어, 의미를 입력하도록 함<br/>
  vi.	addItem(): add() method에서 입력한 단어를 list에 추가<br/>
  vii.	updateItem(): 단어 수정 기능. listAll(String keyword)를 통해 수정하고 싶은 단어를 수정<br/>
  viii.	deleteItem(): 단어 삭제 기능. listAll(String keyword)를 통해 삭제하고 싶은 단어를 삭제<br/>
  ix.	loadFile(): “Dictionary.txt”에 들어있는 레벨, 단어, 의미를 ‘|’로 구분하여 list에 저장<br/>
  x.	saveFIle(): 실행을 통한 단어장 변경사항을 다시 “Dictionary.txt”에 저장<br/>
<br/>
4.	WordManager : WordCRUD를 사용한 데이터 처리<br/>
<br/> 
### < Class 구성 목록 ><br/>
- ICRUD : CRUD를 위한 interface<br/>
- Word : 데이터클래스<br/>
- WordCRUD : ICRUD interface 구현제<br/>
- WordManager : WordCRUD를 사용한 데이터 처리<br/>
- Main : static main 함수, starter class<br/>
<br/>

### < 실행 결과 ><br/>
#### _1. 모든 단어 보기 기능_ <br/>
![1번기능](./screenshots//1.png)
![1번기능](./screenshots//1_2.png)
<br/><br/>

#### _2. 수준별 단어 보기 기능_<br/>
![2번기능](./screenshots/2.png)
<br/><br/>

#### _3. 단어 검색 기능_
![3번기능](./screenshots//3.png)
<br/><br/>

#### _4. 단어 추가 기능_<br/>
![4번기능](./screenshots//4.png)
![4번기능](./screenshots//4_2.png)
<br/><br/>

#### _5. 단어 수정 기능_
![5번기능](./screenshots//5.png)
![5번기능](./screenshots//5_2.png)
<br/><br/>

#### _6. 단어 삭제 기능_
![6번기능](./screenshots//6.png)
<br/><br/>

#### _7. 파일 저장 기능_
![7번기능](./screenshots//7.png)
![7번기능](./screenshots//7_2.png)
<br/><br/>

#### _0. 나가기 기능_
![0번기능](./screenshots//0.png)
