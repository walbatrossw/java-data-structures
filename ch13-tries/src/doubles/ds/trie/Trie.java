package doubles.ds.trie;

import java.util.ArrayList;
import java.util.List;

public class Trie {

    private Node root;  // 루트 노드
    private int indexOfSingleChild;

    public Trie() {
        this.root = new Node(""); // 루트 노드 빈문자열로 초기화
    }

    // 삽입
    public void insert(String key, int value) {

        Node tempNode = root;   // 루트 노드로 초기화

        // 입력한 key의 길이 만큼 반복
        for (int i = 0; i < key.length(); i++) {

            char c = key.charAt(i);    // 알파벳 추출
            int asciiIndex = transformASCIIIndex(c); // 추출한 알파벳을 배열 인덱스에 맞게 저장할 수 있도록 ascii 값 변환

            // 추출한 알파벳을 가진 하위노드가 존재 하지 않으면
            if (tempNode.getChild(asciiIndex) == null) {
                Node node = new Node(String.valueOf(c));    // 새로운 노드 생성
                tempNode.setChild(asciiIndex, node, value); // 하위노드로 세팅
                tempNode = node;                            // 하위 노드로 이동
            } else {
                tempNode = tempNode.getChild(asciiIndex);   // 하위 노드로 이동
            }
        }

        tempNode.setLeaf(true); // 알파벳 문자들의 삽입이 완료되고 마지막 노드를 leaf 노드로 설정
    }

    // 탐색 : 해당 키가 존재하는지 여부 반환
    public boolean search(String key) {

        Node trieNode = root; // 루트 노드로 초기화

        // 입력한 key의 길이만큼 반복
        for (int i = 0; i < key.length(); i++) {

            int asciiIndex = transformASCIIIndex(key.charAt(i)); // 추출한 알파벳을 배열 인덱스에 맞게 ascii 값 변환

            if (trieNode.getChild(asciiIndex) == null) {    // 추출한 알파벳을 가진 하위 노드가 존재하지 않으면 false 리턴
                return false;
            } else {
                trieNode = trieNode.getChild(asciiIndex);   // 하위 노드로 이동
            }
        }

        return true;
    }

    // 탐색 : 해당 키값에 해당하는 값 반환
    public Integer searchAsMap(String key) {

        Node trieNode = root; // 루트 노드로 초기화

        // 입력한 key의 길이만큼 반복
        for (int i = 0; i < key.length(); i++) {

            int asciiIndex = transformASCIIIndex(key.charAt(i)); // 추출한 알파벳을 배열 인덱스에 맞게 ascii 값 변환

            if (trieNode.getChild(asciiIndex) != null) {    // 추출한 알파벳을 가진 하위 노드가 존재하면
                trieNode = trieNode.getChild(asciiIndex);   // 하위 노드로 이동
            } else {    // 존재하지 않으면 null 반환
                return null;
            }
        }

        return trieNode.getValue();
    }

    // Autocomplete : 자동완성
    public List<String> allWordsWithPrefix(String prefix) {

        Node trieNode = root;   // 루트 노드로 초기화

        List<String> allWords = new ArrayList<>();

        // 접두사 길이 만큼 반복 수행
        for (int i = 0; i < prefix.length(); i++) {
            int asciiIndex = transformASCIIIndex(prefix.charAt(i)); // 추출한 알파벳을 배열 인덱스에 맞게 ascii 값 변환
            trieNode = trieNode.getChild(asciiIndex);               // 하위 노드로 이동
        }

        collect(trieNode, prefix, allWords); // 접두사 이후의 단어들 모음
        return allWords;
    }

    // 가장 긴 접두사 반환
    public String longestCommonPrefix() {
        Node trieNode = root; // 루트 노드로 초기화
        String longestCommonPrefix = ""; // 빈 문자열로 초기화

        // 하위노드가 여러개 이거나 leaf 노드일 때까지 반복 수행
        while (countNumOfChildren(trieNode) == 1 && !trieNode.isLeaf()) {
            trieNode = trieNode.getChild(indexOfSingleChild);
            longestCommonPrefix = longestCommonPrefix + String.valueOf((char) (indexOfSingleChild + 'a'));
        }
        return longestCommonPrefix;
    }

    // 하위 노드의 갯수 반환
    private int countNumOfChildren(Node trieNode) {
        int numOfChildren = 0; // 하위 노드 개수 0으로 초기화

        // 하위 노드의 개수 만큼 반복 수행
        for (int i = 0; i < trieNode.getChildren().length; i++) {
            // 하위 노드가 존재하면
            if (trieNode.getChild(i) != null) {
                numOfChildren++; // 하위 노드 1 증가
                indexOfSingleChild = i; // 단일 노드의 인덱스
            }
        }
        return numOfChildren;
    }

    // 자동완성 단어 수집
    private void collect(Node node, String prefix, List<String> allWords) {
        // 노드가 null 이면 메서드 종료
        if (node == null) {
            return;
        }
        // leaf 노드이면 allWords에 저장
        if (node.isLeaf()) {
            allWords.add(prefix);
        }
        // 노드의 자식노드의 수 만큼 반복 수행
        for (Node childNode : node.getChildren()) {
            if (childNode == null) {
                continue;
            }
            // 자식노드의 알파벳
            String childCharacter = childNode.getCharacter();
            collect(childNode, prefix + childCharacter, allWords); // 접두사 + 추출한 알파벳, 반복수행을 위해 재귀호출
        }
    }

    // 정렬
    public void sort() {
        List<String> list = allWordsWithPrefix("");
        for (String s : list) {
            System.out.print(s + " ");
        }
        System.out.println();
    }

    // ASCII 값을 배열에 인덱스에 맞게 변환
    private int transformASCIIIndex(char c) {
        return c - 'a';
    }
}
