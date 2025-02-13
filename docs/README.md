## 1단계 기능 요구사항 정리

### 카드
- [x] 카드는 4가지(스페이드, 클로버, 하트, 다이아몬드) 문양중 하나를 가진다.
- [x] 카드는 2~9의 숫자 또는 'A', 'J', 'Q', 'K'의 문자를 가진다.

### 덱
- [x] 자신이 가지고 있는 카드 중 한 장을 플레이어에게 제공할 수 있다.

### 플레이어가 받은 카드
- [x] 플레이어가 받은 한 장의 카드를 추가할 수 있다.
- [x] 받은 카드의 총 점수를 계산할 수 있다.
  - 숫자 카드는 해당 숫자만큼의 점수로 계산된다.
  - J, Q, K 카드는 모두 10으로 계산된다.
- [x] A 카드는 1 또는 11 중 하나를 선택하여 계산할 수 있다.
- [x] 현재 패의 버스트 여부를 판단할 수 있다.

### 플레이어
- [x] 덱으로 부터 카드 한장을 받아올 수 있다.
- [x] 자신의 점수를 계산할 수 있다.
- [x] 자신의 버스트 여부를 판단할 수 있다.
- [x] 중복된 이름이 있으면 예외가 발생한다.

### 딜러
- [x] 덱으로 부터 카드 한장을 받아올 수 있다.
- [x] 자신의 점수를 계산할 수 있다.
- [x] 자신의 버스트 여부를 판단할 수 있다.
- [x] 자신의 현재 점수가 17점 이상이 될 때까지 추가로 카드를 받는다.

### 게임 결과 계산
- [x] 플레이어들의 승리/패배/무승부 여부를 계산할 수 있다.
- [x] 딜러의 전적을 계산할 수 있다.

## 2단계 기능 요구사항 추가

### 플레이어의 배팅 금액
- [x] 플레이어는 게임을 시작할 때 배팅 금액을 입력한다.

### 최종 수익 계산
- [x] 각 플레이어 별 수익을 계산할 수 있다.
  - 게임에서 승리한 플레이어는 배팅 금액만큼의 돈을 추가로 받는다.
  - 블랙잭으로 승리한 플레이어는 배팅 금액의 1.5배만큼의 돈을 추가로 받는다.
    - 단, 딜러도 블랙잭인 경우 무승부이며, 플레이어는 배팅 금액을 돌려받는다.
  - 게임에서 패배한 플레이어는 배팅 금액을 모두 잃는다.
- [x] 딜러의 최종 수익을 계산할 수 있다.
