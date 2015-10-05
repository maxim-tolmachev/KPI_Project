# KPI_Project
public void switchParser(char ch){
        switch (typeOfParser){
            case MainParserMarker:
                dataParser = mainParser;
                System.out.println("now mainParser is active, current char is "+ch);
                break;

            case LineCommentParserMarker:
                dataParser = lineCommentParser;
                System.out.println("now lineCommentParser is active, current char is "+ch);
                break;

            case BlockCommentParserMarker:
                dataParser =   blockCommentParser;
                System.out.println("now blockCommentParser is active, current char is "+ch);
                break;

            case ValueSectionParserMarker:

                valueSectionParser.addFirstSymbol(ch);
                dataParser = valueSectionParser;
                System.out.println("now valueSectionParser is active, current char is "+ch);
                break;

        }
    }
