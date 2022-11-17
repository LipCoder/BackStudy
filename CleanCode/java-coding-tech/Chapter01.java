import java.nio.file.Files;

class Laboratory {
    
    Microscope microscope;

    /**
     * 1.1 쓸데없는 비교 피하기
     * 
     *      메서드에서는 다중 반환문을 사용하자!
     *      종료 지점을 위해서 여러 개 배치하는 것이 제어 흐름을 보았을 때 더 구조적이다.
     */
    Result analyze(Sample sample) {
        // if (microscope.isInorganic(sample) == true) {   쓸데 없는 비교!!
        if (microscope.isInorganic(sample)) {
            return Result.INORGANIC;
        } else {
            return analyzeOrganic(sample);
        }
    }
    private Result analyzeOrganic(Sample sample) {
        // if (microscope.isInorganic(sample) == false) {  쓸데 없는 비교!!
        if (microscope.isInorganic(sample)) {
            return Result.ALIEN;
        } else {
            return Result.HUMANOID;
        }
    }

     /**
     * 1.2 부정 피하기
     */
    private Result analyzeOrganic_(Sample sample) {        
        // if (microscope.isInorganic(sample)) { 부정문은 피하도록 하자!
        // 조건문의 분기 위치를 바꾸어 부정문을 회피하였다.    
        if (microscope.isHumanoid(sample)) {    
            return Result.HUMANOID;
        } else {
            return Result.ALIEN;
        }
    }
   
}


class Astronaut {

    String name;
    int missions;

    /**
     * 1.3 불 표현식을 직접 반환
     */
    // 쓸데없는 비교문과 불 표현식 반환이 들어갈 필요가 전혀 없음.
    boolean isValid() {
        if (missions < 0 || name == null || name.trim().isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

    boolean isValid_() {
    	// 기존 드모르간 법칙을 적용하여 조건문을 부정
	return missions >= 0 && name != null && !name.trim().isEmpty();
    }
}

class SpaceShip {

    Crew crew;
    FuelTank fuelTank;
    Hull hull;
    Navigator navigator;
    OxygenTank oxygenTank;

    /**
     * 1.4  불 표현식 간소화  
     */
    boolean willCrewSurvive() {
        // 굉장히 보기 불편하고 이해가 잘 되지 않는다.
        return hull.holes == 0 &&
            fuelTank.fuel >= navigator.requiredFuelToEarth() &&
            oxygenTank.lastsFor(crew.size) > navigator.timeToEarth();
    }

    boolean willCrewSurvive_() {
        boolean hasEnoughResources = hasEnoughFuel() && hasEnoughOxygen();
        return hull.isIntact() && hasEnoughResources;
    }

    private boolean  hasEnoughOxygen() {
        return oxygenTank.lastFor(crew.size) > navigator.timeToEarth();
    }

    private boolean hasEnoughFuel() {
        return fuelTank.fuel >= navigator.requiredFuelToEarth();
    }
}


/**
 * 1.5 조건문에서 NullPointerException 피하기
 * 
 * 경험적으로 매개변수 검사는 외부에서 사용 가능한 
 * public, default, protected 메서드에서만 하면 된다.
 * 
 * private 메서드는 null을 전달하지 않도록 할 수 있기 때문이다.
 */
class Logbook {

    void writeMessage(String message, Path location) throws IOException {
        // null 검사를 하지 않는다.
        if (Files.isDirectory(location)) {
            throw new IllegalArgumentException("The path is invalid!");
        }
        // 조건문 순서가 잘못 되었음
        if (message.trim().equals("") || message == null) {
            throw new IllegalAccessException("The message is invalild!");
        }

        if (location == null || Files.isDirectory(location)) {
            throw new IllegalArgumentException("The path is invalid!");
        }
        if (message == null || message.trim().equals("")) {
            throw new IllegalAccessException("The message is invalild!");
        }
    }
}

/**
 * 1.6 스위치 실패 회피하기
 * 
 *      꼭 break를 잊지 말자.
 *      모든 case 조건을 만족하는 switch문을 만들었는지 검토하자
 *      (case문으로 필요없는 것, 혹은 만족하지 않는 것들은 default 조건에서 모두 처리)
 */

/**
 * 1.7 항상 괄호 사용하기
*/

/**
 * 1.8 코드 대칭 이루기
 * 
 * 관심사 있는 애들끼리 묶는다.
 */
class BoardComputer {
    CruiseControl cruiseControl;

    void authorize(User user) {
        Object.requireNonNull(user);
        if (user.isInknown()) {
            cruiseControl.logUnauthorizedAccessAttempt();
        } else if (user.isAstronaut()) {
            cruiseControl.grantAccess(user);
        } else if (user.isCommander()) {
            cruiseControl.grantAccess(user);
            cruiseControl.grantAdminAccess(user);
        }
    }
    // 관심사끼리 if 문을 분리하자!!

    void authorize_(User user) {
        // 코드의 대칭성을 향상시키자!

        // 권한을 부여하지 않는 코드
        Object.requireNonNull(user);
        if (user.isInknown()) {
            cruiseControl.logUnauthorizedAccessAttempt();
        } 
         
        // 권한을 부여하는 코드
        if (user.isAstronaut()) {
            cruiseControl.grantAccess(user);
        } else if (user.isCommander()) {
            cruiseControl.grantAccess(user);
            cruiseControl.grantAdminAccess(user);
        }
    }
}