1. ShowFactory에 생성패턴 AbstractFactory 사용 :
Show 클래스의 하위 클래스들은 각 객체의 특성에 따라 다양한 출연자, 주최측, 예술가들을 가질 수 있다. 따라서 하위 클래스에 따라 생성되는 객체를 바꿀 수 있도록 한다.

2. Review 클래스에 구조패턴 Proxy를 사용 :
Review 클래스는 이미지를 가질 수 있고, 이것은 RealReview 클래스가 가지고 있다. 해당 이미지를 로딩할 때 ProxyReview를 두고 임시 이미지를 출력한다.

3. Review 클래스에 행동 패턴 Iterator를 사용 :
특정 객체(공연 또는 사용자)의 Review를 보여주는 displayReview()함수에서는 최신순으로 보기, 별점순으로 보기 등의 옵션이 존재할 수 있다. 따라서 순회방식을 ReviewIterator에서 관리할 수 있도록 한다.

4. Preference Controller 클래스에 행동패턴 observer 사용 :
사용자 취향이 바뀔 때, 시스템이 이를 감지하고 추천 알고리즘을 갱신하는 경우에 사용한다.

5. Location 클래스에서 구조패턴 Flyweight 사용 :
이미 생성된 객체를 재사용하고 중복 생성을 방지 -> 장소 이름이 같을 경우에 이미 생성된 객체를 재사용하여 메모리 효율을 높인다.

6. Path finder 클래스에 생성패턴 Factory Method 사용 :
Path finder 클래스의 경우, 여러 종류의 경로 탐색 알고리즘을 지원한다. findPath 함수가 실제로 어떤 경로 탐색 알고리즘을 사용할지를 서브 클래스에서 결정하도록 한다. (ex, 도보로만 가는 경로, 버스로만 가는 경로, 버스와 지하철을 함께 이용해 가는 경로, 지하철만 이용해서 가는 경로, 자차로 가는 경로)

7. UserManager 클래스의 createUser, deleteUser, updateUser 메소드에 생성 패턴 Factory Method 사용 :
UserManager 클래스에서 User 객체를 생성할 때 어떤 타입의 User를 생성할지 서브클래스에서 결정할 수 있도록 한다.

8. LoginController 클래스의 authenticate 메소드에 행동 패턴 Strategy 사용 :
여러 가지 인증 방법을 지원한다. (ex. SMS 인증, 카카오 인증 등을 각각의 전략으로 구현)

9. SMSVerification 및 KakaoVerification 클래스에 구조 패턴 Adapter 사용 :
서로 다른 인증 방식 (SMS 및 카카오) 을 일관된 인터페이스로 사용하기 위해 Adapter 패턴을 사용한다.