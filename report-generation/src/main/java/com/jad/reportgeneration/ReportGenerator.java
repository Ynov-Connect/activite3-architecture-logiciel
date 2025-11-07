package com.jad.reportgeneration;

import com.jad.api.IReportGenerator;
import com.jad.model.SensorData;
import com.jad.report.spi.ReportType;

import java.util.List;

public class ReportGenerator implements IReportGenerator {
    @Override
    public void generate(final ReportType reportType, List<SensorData> data) {
        switch (reportType) {
            case TEXT -> new TextReportGenerator().generateReport(data);
            case CSV -> new CSVReportGenerator().generateReport(data);
        }
    }
}
