package com.hcq.mir2.service;

import com.hcq.mir2.dto.PageResult;
import com.hcq.mir2.entries.Model;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Mir2Service {

    private List<Model> current = new ArrayList<>();
    private List<List<Model>> pageCurrent = new ArrayList<>();
    private long total = 0;
    private long pageSize = 20;


    public List<Model> getTop(int offset, int size) {
        return current;
    }

    public List<Model> getAll() {
        return current;
    }

    public PageResult<Model> getByPage(long pageIndex) {
        PageResult<Model> result = new PageResult<>();
        result.setPageIndex(pageIndex);
        result.setPageSize(this.pageSize);
        result.setTotal(this.total);
        result.setRows(pageCurrent.get((int) pageIndex - 1));
        return result;
    }


    public void setCurrent(List<Model> current) {

        this.current = current;
        this.total = current.size();
        List<List<Model>> lists = splitList(current, (int)this.pageSize);
        this.pageCurrent = lists;
    }

    public <T> List<List<T>> splitList(List<T> list, int pageSize) {
        int listSize = list.size();
        int page = (listSize + (pageSize - 1)) / pageSize;

        List<List<T>> listArray = new ArrayList<List<T>>();
        for (int i = 0; i < page; i++) {
            List<T> subList = new ArrayList<T>();
            for (int j = 0; j < listSize; j++) {
                int pageIndex = ((j + 1) + (pageSize - 1)) / pageSize;
                if (pageIndex == (i + 1)) {
                    subList.add(list.get(j));
                }
                if ((j + 1) == ((j + 1) * pageSize)) {
                    break;
                }
            }
            listArray.add(subList);
        }
        return listArray;
    }

}
