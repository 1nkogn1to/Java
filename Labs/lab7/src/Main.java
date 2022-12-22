import java.io.*;
import java.util.*;
import java.util.regex.*;

class Company {
    public String name;
    public String shortTitle;
    public String dateUpdate;
    public String address;
    public String dateFoundation;
    public int countEmployees;
    public String auditor;
    public String phone;
    public String email;
    public String branch;
    public String activity;
    public String link;
    public Company(String str) {
        StringTokenizer st = new StringTokenizer(str, ";\n");
        name = st.nextToken();
        shortTitle = st.nextToken();
        dateUpdate = st.nextToken();
        address = st.nextToken();
        dateFoundation = st.nextToken();
        countEmployees = Integer.parseInt(st.nextToken());
        auditor = st.nextToken();
        phone = st.nextToken();
        email = st.nextToken();
        branch = st.nextToken();
        activity = st.nextToken();
        link = st.nextToken();
    }
    public String toString() {
        return name + " " + shortTitle + " " + dateUpdate + " " + address + " " + dateFoundation + " " + countEmployees + " " + auditor + " " + phone + " " + email + " " + branch + " " + activity + " " + link;
    }
}

public class Main {
    public static void AddToList(List<Company> list, String str) {
        Company company = new Company(str);
        list.add(company);
    }
    public static void read_from_file(List<Company> list) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("src/input.csv"));
        String line;
        while ((line = br.readLine()) != null) {
            AddToList(list, line);
        }
        br.close();
    }

    public static void write_to_xml(List<Company> list) throws IOException {
        if (list.size() == 0) {
            return;
        }
        BufferedWriter bw = new BufferedWriter(new FileWriter("src/output.xml"));
        bw.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
        for (Company company : list) {
            bw.write("<company>\n");
            bw.write("\t<name>" + company.name + "</name>\n");
            bw.write("\t<shortTitle>" + company.shortTitle + "</shortTitle>\n");
            bw.write("\t<dateUpdate>" + company.dateUpdate + "</dateUpdate>\n");
            bw.write("\t<address>" + company.address + "</address>\n");
            bw.write("\t<dateFoundation>" + company.dateFoundation + "</dateFoundation>\n");
            bw.write("\t<countEmployees>" + company.countEmployees + "</countEmployees>\n");
            bw.write("\t<auditor>" + company.auditor + "</auditor>\n");
            bw.write("\t<phone>" + company.phone + "</phone>\n");
            bw.write("\t<email>" + company.email + "</email>\n");
            bw.write("\t<branch>" + company.branch + "</branch>\n");
            bw.write("\t<activity>" + company.activity + "</activity>\n");
            bw.write("\t<link>" + company.link + "</link>\n");
            bw.write("</company>\n");
        }
        bw.close();
    }
    public static void write_to_json(List<Company> list) throws IOException {
        if (list.size() == 0) {
            return;
        }
        BufferedWriter bw = new BufferedWriter(new FileWriter("src/output.json"));
        bw.write("{\n");
        for (int i = 0; i < list.size(); i++) {
            bw.write("\t\"company" + (i + 1) + "\": {\n");
            bw.write("\t\t\"name\": \"" + list.get(i).name + "\",\n");
            bw.write("\t\t\"shortTitle\": \"" + list.get(i).shortTitle + "\",\n");
            bw.write("\t\t\"dateUpdate\": \"" + list.get(i).dateUpdate + "\",\n");
            bw.write("\t\t\"address\": \"" + list.get(i).address + "\",\n");
            bw.write("\t\t\"dateFoundation\": \"" + list.get(i).dateFoundation + "\",\n");
            bw.write("\t\t\"countEmployees\": \"" + list.get(i).countEmployees + "\",\n");
            bw.write("\t\t\"auditor\": \"" + list.get(i).auditor + "\",\n");
            bw.write("\t\t\"phone\": \"" + list.get(i).phone + "\",\n");
            bw.write("\t\t\"email\": \"" + list.get(i).email + "\",\n");
            bw.write("\t\t\"branch\": \"" + list.get(i).branch + "\",\n");
            bw.write("\t\t\"activity\": \"" + list.get(i).activity + "\",\n");
            bw.write("\t\t\"link\": \"" + list.get(i).link + "\"\n");
            bw.write((i == list.size() - 1) ? "\t}\n" : "\t},\n");
        }
        bw.write("}\n");
        bw.close();
    }

    public static void write_to_txt(List<Company> list) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("src/logfile.txt"));
        String content = "", line;
        while ((line = br.readLine()) != null) {
            content += line + "\n";
        }
        br.close();
        BufferedWriter bw = new BufferedWriter(new FileWriter("src/logfile.txt"));
        bw.write(content);
        bw.write("Request:");
        for (int i = 0; i < list.size(); i++) {
            bw.write("\n" + list.get(i).toString());
        }
        bw.close();
    }

    public static List<Company> get_all_company_by_shortTitle(List<Company> list, String shortTitle) {
        List<Company> result = new ArrayList<Company>();
        for (Company company : list) {
            if (company.shortTitle.equals(shortTitle)) {
                result.add(company);
            }
        }
        return result;
    }

    public static List<Company> get_all_company_by_branch(List<Company> list, String branch) {
        List<Company> result = new ArrayList<Company>();
        for (Company company : list) {
            if (company.branch.equals(branch)) {
                result.add(company);
            }
        }
        return result;
    }

    public static List<Company> get_all_company_by_activity(List<Company> list, String activity) {
        List<Company> result = new ArrayList<Company>();
        for (Company company : list) {
            if (company.activity.equals(activity)) {
                result.add(company);
            }
        }
        return result;
    }

    public static List<Company> get_all_company_by_dateFoundation(List<Company> list, String dateFoundationLeftBorder, String dateFoundationRightBorder) {
        List<Company> result = new ArrayList<Company>();
        Pattern pattern = Pattern.compile("(\\d{2})\\.(\\d{2})\\.(\\d{4})");
        Matcher matcherLeftBorder = pattern.matcher(dateFoundationLeftBorder);
        Matcher matcherRightBorder = pattern.matcher(dateFoundationRightBorder);
        for (Company company : list) {
            Matcher matcher = pattern.matcher(company.dateFoundation);
            if (matcher.matches() && matcherLeftBorder.matches() && matcherRightBorder.matches()) {
                int year = Integer.parseInt(matcher.group(3));
                int yearLeftBorder = Integer.parseInt(matcherLeftBorder.group(3));
                int yearRightBorder = Integer.parseInt(matcherRightBorder.group(3));
                if (year > yearLeftBorder && year < yearRightBorder) {
                    result.add(company);
                }
                else if (year == yearLeftBorder) {
                    int month = Integer.parseInt(matcher.group(2));
                    int monthLeftBorder = Integer.parseInt(matcherLeftBorder.group(2));
                    if (month > monthLeftBorder) {
                        result.add(company);
                    }
                    else if (month == monthLeftBorder) {
                        int day = Integer.parseInt(matcher.group(1));
                        int dayLeftBorder = Integer.parseInt(matcherLeftBorder.group(1));
                        if (day >= dayLeftBorder) {
                            result.add(company);
                        }
                    }
                }
                else if (year == yearRightBorder) {
                    int month = Integer.parseInt(matcher.group(2));
                    int monthRightBorder = Integer.parseInt(matcherRightBorder.group(2));
                    if (month < monthRightBorder) {
                        result.add(company);
                    }
                    else if (month == monthRightBorder) {
                        int day = Integer.parseInt(matcher.group(1));
                        int dayRightBorder = Integer.parseInt(matcherRightBorder.group(1));
                        if (day <= dayRightBorder) {
                            result.add(company);
                        }
                    }
                }
            }
            else {
                System.out.println("Wrong date format");
                return result;
            }
        }
        return result;
    }

    public static List<Company> get_all_company_by_countEmployees(List<Company> list, int countEmployeesLeftBorder, int countEmployeesRightBorder) {
        List<Company> result = new ArrayList<Company>();
        for (Company company : list) {
            if (company.countEmployees >= countEmployeesLeftBorder && company.countEmployees <= countEmployeesRightBorder) {
                result.add(company);
            }
        }
        return result;
    }

    public static void options_menu() {
        System.out.println("Choose what to output: ");
        System.out.println("1. Output all companies");
        System.out.println("2. Output all companies by shortTitle");
        System.out.println("3. Output all companies by branch");
        System.out.println("4. Output all companies by activity");
        System.out.println("5. Output all companies by dateFoundation");
        System.out.println("6. Output all companies by countEmployees");
    }

    public static void actions(List<Company> list) throws IOException {
        Scanner scan = new Scanner(System.in);
        int answer = scan.nextInt();
        List<Company> result = new ArrayList<Company>();
        switch (answer) {
            case 1:
                result = list;
                break;
            case 2:
                System.out.println("Enter shortTitle: ");
                String shortTitle = scan.next();
                result = get_all_company_by_shortTitle(list, shortTitle);
                break;
            case 3:
                System.out.println("Enter branch: ");
                String branch = scan.next();
                result = get_all_company_by_branch(list, branch);
                break;
            case 4:
                System.out.println("Enter activity: ");
                String activity = scan.next();
                result = get_all_company_by_activity(list, activity);
                break;
            case 5:
                System.out.println("Enter dateFoundation left border: ");
                String dateFoundationLeftBorder = scan.next();
                System.out.println("Enter dateFoundation right border: ");
                String dateFoundationRightBorder = scan.next();
                result = get_all_company_by_dateFoundation(list, dateFoundationLeftBorder, dateFoundationRightBorder);
                break;
            case 6:
                System.out.println("Enter countEmployees left border: ");
                int countEmployeesLeftBorder = scan.nextInt();
                System.out.println("Enter countEmployees right border: ");
                int countEmployeesRightBorder = scan.nextInt();
                result = get_all_company_by_countEmployees(list, countEmployeesLeftBorder, countEmployeesRightBorder);
                break;
            default:
                System.out.println("Wrong input");
                break;
        }
        write_to_json(result);
        write_to_xml(result);
        write_to_txt(result);
        scan.close();
    }

    public static void main(String[] args) throws IOException {
        List<Company> list = new ArrayList<Company>();
        read_from_file(list);
        options_menu();
        actions(list);
    }
}