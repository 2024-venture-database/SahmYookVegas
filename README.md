<div align = "center">
<h1> 💸 SAHMYOOK VEGAS 💸 </h1>
</div>

> **삼육대학교 벤처아카데미 데이터베이스 프로젝트 2팀**
> <br>
> **개발기간 : 2024.4.8~2024.4.16**
## 🙌 목차 
1. 팀 소개
2. 프로젝트 소개
3. 개발 과정
4. 프로젝트 주요 기능
5. 기술 스택
## 🙋‍♀️ 팀 소개

## 💡 프로그램 소개
- 💸SAHMYOOK VEGAS💸 는 고객과 관리자가 모두 사용할 수 있는 카지노 키오스크입니다.
- 고객은 회원가입과 로그인 후 돈을 충전하고, 고객 등급에 따라 크레딧을 적립할 수 있습니다.  
- 충전된 돈은 칩으로 교환하거나 카지노 내의 상품을 구매할 수 있습니다.
- 교환된 칩은 키오스크의 룰렛 게임에서 사용 가능하며, 칩을 돈으로 반환하는 것도 가능합니다.
- 관리자는 고객의 정보를 조회하고 관리하는 관리자 서비스 기능을 이용할 수 있습니다.  

## 🔎 개발 환경

![java](https://img.shields.io/badge/java-007396?style=for-the-badge&logo=java&logoColor=white)
![mysql](https://img.shields.io/badge/mysql-4479A1?style=for-the-badge&logo=mysql&logoColor=white)
![intelliJIDEA](https://img.shields.io/badge/intelliJIDEA-000000?style=for-the-badge&logo=intellijIDEA&logoColor=white)

### 🙋‍♀️ 협업 툴
![notion](https://img.shields.io/badge/notion-000000?style=for-the-badge&logo=notion&logoColor=white)
![discord](https://img.shields.io/badge/discord-5865F2?style=for-the-badge&logo=discord&logoColor=black)
![Github](https://img.shields.io/badge/GitHub-181717?style=for-the-badge&logo=GitHub&logoColor=white)
***
### ERD 다이어그램
***
![image](https://github.com/java-teamproject-syu000/javateamproject/assets/144655675/e04460e9-b47e-45c9-a41f-5a75c1e8a717)
***
### 브랜치 생성
- main 브랜치 : 최종 코드 관리. PR을 통해 merge함 
- prototype 브랜치 : 개발 단계에서 master 역할을 하는 브랜치
- feature 브랜치 : 각자 담당한 기능 단위로 브랜치를 나누어서 사용 

***
## ⚙ 프로그램 주요 기능
***
### ⚙ 회원가입 및 로그인 기능
1. **회원가입**
  - 사용자는 이름, 아이디, 비밀번호, 전화번호, 주소를 입력하여 회원가입할 수 있습니다.
  - 아이디는 고유해야 하며, 다른 사용자와 중복될 수 없습니다.
2. **로그인**
  - 회원가입한 사용자는 아이디와 비밀번호를 입력하여 로그인할 수 있습니다.
  - 로그인 시, 사용자 등급에 따라 고객 서비스 화면 또는 관리자 서비스 화면으로 이동합니다.
---
### ⚙ 지갑 충전 및 상품 구매
고객 서비스에는 지갑 충전 및 상품 구매 기능이 포함되어 있습니다.
- **지갑 충전**: 사용자는 지갑에 돈을 충전할 수 있습니다. 충전한 돈은 지갑의 잔액으로 누적되며, 충전할 때에는 크레딧도 적립됩니다.
- **상품 구매**: 사용자는 지갑의 잔액 또는 크레딧을 사용하여 카지노 내에서 판매되는 상품을 구매할 수 있습니다.
***
### ⚙ 칩 서비스
칩 서비스는 사용자가 게임 내에서 소유한 칩을 교환하거나 반환하는 기능을 제공합니다.
1. **칩 교환**
   - 사용자가 보유한 칩을 일정한 비율에 따라 다른 칩으로 교환할 수 있습니다.
   - 교환할 칩의 종류와 개수를 입력하면 해당하는 칩으로 교환됩니다.

2. **칩 반환**
   - 사용자가 보유한 칩을 일정한 비율에 따라 다른 칩으로 반환할 수 있습니다.
   - 반환할 칩의 종류와 개수를 입력하면 해당하는 칩으로 반환됩니다.

### 교환 및 반환 과정
1. 사용자는 프로그램을 실행하고 교환 또는 반환할 칩의 종류와 개수를 입력합니다.
2. 입력한 정보는 데이터베이스에 저장되고, 교환 또는 반환 과정이 수행됩니다.
3. 교환 또는 반환 결과가 성공적으로 처리되면 사용자에게 알림이 표시됩니다.
***
### ⚙ 관리자 서비스
1. 고객 정보 관리: 관리자는 고객의 정보를 조회하고 수정 또는 삭제할 수 있습니다.
2. 게임 관리: 관리자는 카지노에 게임을 추가, 삭제하고 게임에 대한 설정을 관리할 수 있습니다.
3. 로그 조회: 시스템 로그를 조회하여 매출 정보를 확인하고, 사용자 활동을 모니터링할 수 있습니다.
