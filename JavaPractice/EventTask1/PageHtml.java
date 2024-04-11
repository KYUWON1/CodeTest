//심규원
package JavaPractice.EventTask1;

public class PageHtml {
    static class Pager {
        long totalPage;

        Pager(long count){
            this.totalPage = count;
        }

        public String html(long index){
            long pageNum = Math.round((float)totalPage / 10); // 13페이지
            long start = ((index / 11) * 10)+1; // 시작지점결정 1~10은 1부터. 11은 11부터
            long end = start + 10; // 종료지점 계산
            //만약 총페이지수보다 크면 해당 페이지수로 계산
            if(end > pageNum){
                end = pageNum+1;
            }

            String html = "";
            html += "<a href='#'>[처음]</a>\n<a href='#'>[이전]</a>\n\n";
            for (long i = start; i < end; i++) {
                if(index == i){
                    html += "<a href='#' class='on'>"+i+"</a>\n";
                    continue;
                }
                html += "<a href='#'>"+i+"</a>\n";
            }

            html += "\n<a href='#'>[다음]</a>\n<a href='#'>[마지막]</a>";

            return html;
        }
    }
    public static void main(String[] args) {
        long totalCount = 127;
        long pageIndex = 12;



        Pager pager = new Pager(totalCount);
        System.out.println(pager.html(pageIndex));
    }
}
