# 기여 방법

## 답안 코드 작성법

참조 링크 :
[깃허브(GitHub)에서의 오픈 소스 프로젝트 기여를 위한 초보자 가이드](https://seongjin.me/how-to-contribute-to-open-source/amp/)

먼저, 현재 페이지 우상단에 있는 버튼들 중 `Fork` 버튼 클릭하여 개인 원격 저장소로 복사해줍니다.

개인 로컬 저장소로 `Fork`한 개인 원격 저장소 코드를 클론합니다,

예를 들어,

```sh
git clone https://github.com/itsmo1031/leetcode-study.git
```

푸시려는 문제의 폴더에서 자기 GitHub 유저네임으로 파일을 생성합니다.

예를 들어,

```sh
cd two-sum
touch itsmo1031.java
```

그 파일 안에 답안 코드를 작성하고, 변경 사항을 커밋합니다.

예를 들어,

```sh
git add itsmo1031.java
git commit -am "two sum solution"
```

## 답안 코드 제출법

작성한 답한 코드를 개인 원격 저장소로 push 합니다.

```sh
git push origin main
```

그 다음, 깃허브 웹사이트 개인 원격저장소에 들어가 좌상단 `Pull request`를 누르고 `Pull request` 탭으로 이동한 뒤, `New pull request` 버튼을 클릭해줍니다.

이제 작업한 코드를 원본 원격 저장소로 'Merge' 하기 위한 'PR'을 생성할 수 있습니다.

`Create pull request` 를 누르기에 앞서, 상단에 있는 `base repository` 와 `head repository` 가 각각 원본 원경 저장소의 main 브렌치와 본인이 작업한 브렌치가 맞는 지 확인해줍니다.

확인이 되었으면, `Create pull request`를 누르고, `Title`의 가장 앞에 **본인의 이름을 포함시켜 주고** `Create pull request` 버튼을 클릭합니다. (예: `[홍길동] 2099. 99. 99. 답안 제출`)

그러면 디스코드에도 알림이 올겁니다. `Pull Request`를 생성한 뒤, 우측 `Project`탭에서 `Iteration`설정을 현재 진행 주차에 맞춰주시기 바랍니다.

또한 `Draft PR` 기능을 활용해 한 번에 모든 솔루션을 제출하기보다 본인의 진행 상황을 주기적으로 업데이트할 수 있도록 합니다.

`Draft` 변환은 `Pull Request` 생성 후 우측 상단 `Still in progress?` 항목을 통해 변환할 수 있습니다.

이제 본인이 작성한 솔루션을 리뷰받을 수 있습니다. 리뷰가 `approved` 된다면 메인 저장소에 `Merge` 하실 수 있습니다.

Pull Request 설명란에 문제를 해결하면서 어려웠던 부분이나 도움이 필요한 부분에 대해 남겨주시면 다른 분들이 리뷰할 때 참고할 수 있어서 좋겠죠?

Pull Request에 대한 모든 프로세스가 완료되었다면, 본인의 Pull Request는 Pull Request 하단 `Merge pull request` 버튼을 클릭하여

직접 `Merge` 진행하도록 합니다.

Pull Request를 생성할 때, `Label`을 추가하여 문제에 대한 본인의 의견을 남겨 주세요. 사용할 수 있는 `Label`은 다음과 같습니다.

- `🙋‍♂️ Help`: 풀지 못했거나 도움이 필요한 문제가 있는 경우
- `🤔 Needs Improvement`: 코드의 개선이 필요한 경우
- `🔥 Challenging`: 30분 이상 고민할 정도로 어려웠던 문제의 경우
- `✅ Solved`: 큰 막힘 없이 풀이한 경우

## PR 답안 코드 리뷰법

본인의 Pull Request 작성 완료 후, 본인 직후 Pull Request를 생성한 스터디원의 솔루션을 리뷰합니다. 예를들어,

![예시](assets/example.png)

위 형식으로 리뷰를 진행합니다. 리뷰 내용은 당시까지 제출 완료된 코드를 기반으로 갯수 제한 없이 자유롭게 작성해 주시되, 유익한 리뷰를 지향하도록 합니다.

본인에게 할당된 리뷰 외 다른 멤버에 대한 코드 리뷰도 언제나 환영합니다.
